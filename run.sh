MY_VAR="/home/tatiana/School/M1-mosig/IDS/IDS-chat-app"

export CLASSPATH=$MY_VAR/lib/Hello.jar:$MY_VAR/lib/Info_itf.jar

# Compiling 
javac -d classes -classpath .:classes src/Info_itf.java
cd classes
jar cvf ../lib/Info_itf.jar Info_itf.class
cd ../

javac -d classes -classpath .:classes src/Info.java
cd classes
jar cvf ../lib/Info.jar Info.class

cd ../
javac -d classes -classpath .:classes src/Hello.java
cd classes
jar cvf ../lib/Hello.jar Hello.class

cd ../
javac -d classes -classpath .:classes src/HelloImpl.java
cd classes
jar cvf ../lib/HelloImpl.jar HelloImpl.class

cd ../
javac -d classes -cp .:classes:lib/Hello.jar:lib/HelloImpl.jar:lib/Info_itf.jar src/HelloServer.java

javac -d classes -cp .:classes:lib/Hello.jar:lib/Info_itf.jar src/HelloClient.java

# cd ../
# Lauching rmi, sever and client 

# rmiregistry &

# java -classpath .:classes:lib/Hello.jar:lib/HelloImpl.jar:lib/Info_itf.jar HelloServer

# java -classpath .:classes:lib/Hello.jar HelloClient localhost


