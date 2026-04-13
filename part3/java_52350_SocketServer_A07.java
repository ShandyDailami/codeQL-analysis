import java.io.*;
import java.net.*;
import java.util.*;

public class java_52350_SocketServer_A07 {  
    static ArrayList<String> bannedIPs = new ArrayList<>();  //List of blocked IP addresses (Add more as needed)           
    
	public static void main(String[] args){         
		Socket socket;            
        ServerSocket serverSock=null ;             
	    try {              
		    System.out.println("Waiting for client on port: "+8096);   //setting up the initial connection           	       
           serverSock = new ServerSocket( 8096 );            	    			        while (true)                    				        	     	{                            socket=null;                      try {                             if ((socket  = serverSock.accept()) !=  null ){                        System.out.println("Connection established with "+                   
   socket.getRemoteSocketAddress());                         //check connection for blocking                  SocketAddress remote =    socketserver . getclient().     (ClientHandshake  request=sockserversessentiallyconnectedwithsocket(the)      server;         if((bannedIPs).contains        ((remote ).toString())) {printwarningmessagesisalreadyblockedbythisip);continue;}
                         BufferedReader in =newBuffereroptimizedreader ( socket .getInputStream());       //read input stream from client                                                  String            line     ;   try         	{                     while(                    (!    Thread.currentThread(). isinterrupted()))  {                 if((line=in                      . readLine())==null) break;              System..println("Received: " +              
           line); }                             socket .close();                   }} catch (IOException e){ SocketException n = new                  IOException(e.getMessage());                    throw   /nwe     //thesocketisnowclosedandthiswshowthat  wearegoingtonowththeclosedsocketserver              exception               isnthandled    }}}