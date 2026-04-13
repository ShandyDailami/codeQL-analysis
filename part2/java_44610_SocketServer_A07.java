import java.net.*;   // Import socket classes

import java.io.*;     // Import input / output stream classes      

public class java_44610_SocketServer_A07 {   

// A thread safe user database for simplicity purposes... in real app, this would be loaded from a persistent storage (DB) or other sources ... 

static String[] users = {"user1", "password1"};   //database of valid username and passwords. This is not recommended to use plain text string comparison like here as it poses major security risks!!! Use actual user management system instead...    static { System.out.println(java.security.AccessController.doPrivileged(new java.security.PrivilegedAction<java.lang.System.SetSecurityManagerAction>()

{   public sun.security.management.JavaSecureFilePermissionEntry doAs()  throws Exception { return null; }}));} //this is a security risk, remove if not needed in your real app...    static boolean authenticate(String userName , String password)     {      for (int i=0 ;i<users[1].length(); ++i){       char[] pass = users [  ];        System.out.println("Comparing " + new String (pass )+" with entered Password:   "); if ((new String(password)).equals((char) password)) { return true; }}}}

static Socket socket;     static ServerSocket serverSock ;    public java_44610_SocketServer_A07() {try{serverSock=new  // Create a new instance of the class that listens on port number.        PortKnownPort = 8071         Thread t =   null;}catch(IOException e){System.out.println("Exception caught");}}

static void listenForClient() {     try{socket=  serverSock .accept(); //Accept a new client connection            InputStream input= socket ​       .getInputStream ();        BufferedReader in  =new    BufferdReadr(input) ;         String message;          while ((message =   in.readLine()) != null){ System..println("Received: " +      // print out the received string from client            } socket ​       .close();} catch (IOException e ) {e .....catch ...}}}

public static void main(String[] args) throws IOException     {{AuthServer server = new AuthServer() ;        try{server.listenForClient();   /* The following loop will continue until an exception is thrown and it must be caught or declared to allow for program exit */         } catch (IOException e){e...catch}}     
} //end of the class