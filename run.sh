MY_VAT_TAT="/home/tatiana/School/M1-mosig/IDS/IDS-chat-app"
MY_VAR_AND="/home/andy/Documents/Workspace/Distributed_system/IDS-chat-app"
MY_VAR=$MY_VAR_AND

export CLASSPATH="$MY_VAR/lib/Hello.jar:$MY_VAR/lib/Hello2.jar:$MY_VAR/lib/Accounting_itf.jar:$MY_VAR/lib/Registry_itf.jar"

# Compiling 
javac -d classes -classpath .:classes src/Accounting_itf.java
cd classes
jar cvf ../lib/Accounting_itf.jar Accounting_itf.class
cd ../

javac -d classes -classpath .:classes src/Accounting.java
cd classes
jar cvf ../lib/Accounting.jar Accounting.class
cd ../

javac -d classes -classpath .:classes src/Registry_itf.java
cd classes
jar cvf ../lib/Registry_itf.jar Registry_itf.class
cd ../

javac -d classes -classpath .:classes src/RegistryImpl.java
cd classes
jar cvf ../lib/RegistryImpl.jar RegistryImpl.class
cd ../

javac -d classes -classpath .:classes src/Hello2.java
cd classes
jar cvf ../lib/Hello2.jar Hello2.class
cd ../

javac -d classes -classpath .:classes src/HelloImpl2.java
cd classes
jar cvf ../lib/HelloImpl2.jar HelloImpl2.class
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

javac -d classes -cp .:classes:lib/Hello.jar:lib/HelloImpl.jar:lib/Hello2.jar:lib/HelloImpl2.jar:lib/RegistryImpl.jar:lib/Registry_itf.jar:lib/Accounting_itf.jar src/HelloServer.java

javac -d classes -cp .:classes:lib/Hello.jar:lib/Hello2.jar:lib/Accounting.jar:lib/Accounting_itf.jar:lib/Registry_itf src/HelloClient.java

# cd ../
# Lauching rmi, sever and client 

# rmiregistry &

# java -classpath .:classes:lib/Hello.jar:lib/HelloImpl.jar:lib/Info_itf.jar HelloServer

# java -classpath .:classes:lib/Hello.jar HelloClient localhost


