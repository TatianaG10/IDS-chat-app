import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ChatDiscussion implements ChatDiscussion_itf {
    private ArrayList<ChatMessage> listMessages;
    private Semaphore listMessagesSem;
    private File saveFile;

    public ChatDiscussion(String fileToSaveTo)
    {
        listMessagesSem = new Semaphore(1);
        saveFile = new File(fileToSaveTo);
        listMessages = new ArrayList<ChatMessage>();
        if (saveFile.isFile())
        {
            try (
                FileInputStream fIn = new FileInputStream(saveFile);
                ObjectInputStream objIn = new ObjectInputStream(fIn);
            ) 
            {
                // Add all the messages present in the file until the EOF
                ChatMessage message;
                for(;;)
                {
                    try 
                    {
                        message = (ChatMessage) objIn.readObject();
                        listMessages.add(message);
                    } 
                    catch (EOFException e) 
                    {
                        break;
                    }
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Error in ChatDiscussion: " + e);
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ChatMessage> getListMessages() throws RemoteException {
        return listMessages;
    }

    public void addNewMessage(ChatMessage message) throws RemoteException {
        try 
        {
            listMessagesSem.acquire();
            listMessages.add(message);
            boolean newFile = false;

            // The file doesn't exist
            if (!saveFile.isFile())
            {
                saveFile.createNewFile();
                newFile = true;
            }

            // Write the message in the file
            try (
                FileOutputStream fOut = new FileOutputStream(saveFile, true);
                ObjectOutputStream objOut = newFile ? 
                    new ObjectOutputStream(fOut) : 
                    // We don't want to write the ObjectOutputStream header for every message we append to the file, just for the first one
                    new ObjectOutputStream(fOut) {@Override protected void writeStreamHeader() throws IOException { reset(); }};
            )
            {
                objOut.writeObject(message);
            } 
            catch (Exception e) 
            {
                System.out.println("Error in ChatDiscussion: " + e);
                e.printStackTrace();
            }
            listMessagesSem.release();
        } 
        catch (Exception e) 
        {
            System.out.println("Error in ChatDiscussion: " + e);
            e.printStackTrace();
        }
    }
}
