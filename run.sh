MY_VAR="/home/tatiana/School/M1-mosig/IDS/IDS-chat-app"

export CLASSPATH=$MY_VAR/lib/Hello.jar:$MY_VAR/lib/Hello2.jar:$MY_VAR/lib/Accouting_itf.jar:$MY_VAR/lib/Registry_itf.jar

# Compiling 
javac -d classes -classpath .:classes src/Accouting_itf.java
cd classes
jar cvf ../lib/Accouting_itf.jar Accouting_itf.class
cd ../

javac -d classes -classpath .:classes src/Accouting.java
cd classes
jar cvf ../lib/Accouting.jar Accouting.class
cd ../

javac -d classes -classpath .:classes src/Registry_itf.java
cd classes
jar cvf ../lib/Registry_itf.jar Registry_itf.class
cd ../

javac -d classes -classpath .:classes src/Registry.java
cd classes
jar cvf ../lib/Registry.jar Registry.class
cd ../

javac -d classes -classpath .:classes src/Hello2.java
cd classes
jar cvf ../lib/Hello2.jar Hello2.class
cd ../

javac -d classes -classpath .:classes src/HelloImpl2.java
cd classes
jar cvf ../lib/HelloImpl2.jar HelloImpl2
cd ../

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


