import java.io.*;   // for InputStream and OutputStream   
import javax.net.ssl.*;  //for SSLServerSocket     
SSLServerSocket srv_socket;// server socket object    
int client_accepted = 0, port=12345 ;       //counter variable to check number of clients connected  
public class java_52845_SocketServer_A03 {   
String data = "Secured Connection";       
static SSLServerSocket server_socket  = null;  /* Server Socket */    
BufferedReader inFromClient ,readerThread,inFROMUSER=null ;      //input stream from client for reading message       DataOutputStream outToClient ...//outputstream to write messages back   
public static void main(String args[]) throws Exception {          new SecureSock();             System.out.println("Server Started at "+port);         server_socket= ( SSLServerSocket )  port ;   while(!Thread.currentThread().isInterrupted())      try{     srv_socket = (SSLServerSocket)server_socket .accept()           PrintWriter outToClient      =  new             PrintWriter(srv_socket.getOutputStream(),true);    //connection established...          inFromUser    =new BufferedReader   (InputStreamReader  (.openStream())) ;
//incoming client details..         System.out.println("Connected to "+        srv_socket .getInetAddress().toString());           new Thread(()).start();       }catch      {System.out."exit()";             }}    //closing resources...   inFromClient=null;     readerThread = null;}