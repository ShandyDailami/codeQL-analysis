import java.io.*;
import java.net.*;   //for socket programming   
public class java_51667_SocketServer_A01 {    
// main method (thread) begins execution of java program      
static public void Main(String argv[]){          
System.out.println("Server");           
try{               System.out.println ("Waiting for client on port 7890...");            
Socket serversocket = new Socket("127.0.0.1",  5643 ); //socket to connect with server       socket, bind the source and listen at given         address      intinety(milliseconds)           System.out.println ("Connected");               BufferedReader inFromServer = new     Read          (serversocket .getInputStream());
//Socket connections are not always reliable; for example on a slow network or if something unexpected happens  // the connection might be closed, then we should close socket             serversocket      = null;} catch(IOException e){System.out                out.println ("Exception caught when trying to connect    and listen : " +   E);} }                    finally{ System .               exit (0 );}}