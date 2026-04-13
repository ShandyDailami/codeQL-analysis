import java.net.*;
import java.io.*;
  
public class java_51848_SocketServer_A03 { 
     public static void main(String args[]) throws Exception{   
         ServerSocket welcomeSocket = new ServerSocket(6013);      //server socket listening for client requests         
           while (true){            
               Socket connectionToClient = welcomeSocket.accept();        //getting a request from the connected user                 
               
               System.out.println("Just connect to " + connectionToClient.getRemoteSocketAddress());    	        		  
                    try { 
                        InputStream inputFromClient=connectionToClient.getInputStream();         			           									   							      						       	 	   	     	       								      StreamHandler handler = new StreamHandler(inputMessage ->{},true);                          //stream Handler for reading the message from client    		          	   } catch (Exception ex) { System.out.println("Error in communication "+ex );connectionToClient.close();  };   
               										}     			        	   							       end;            }}                    ;}}}                     ^_^                     .:::..:.                 ::/'...//                  :- -.-.:-.              `:-..-:'             / '--''\ `.--'' --,--.'.              ..... --- ...