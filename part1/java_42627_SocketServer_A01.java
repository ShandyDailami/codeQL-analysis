import java.io.*;   // Input / Output Streams and their related classes which implements the stream of bytes used to transfer information from one host to another through transport channel, ie socket programming model   

import java.net.*;  //Socket class java_42627_SocketServer_A01 represents a connection between two hosts using an IP protocol suite (such as TCP)    

  

public class SocketServer {        

      public static void main(String args[]){            

            try{                

                  ServerSocket server = new ServerSocket(4000); //Creating a socket and binding it to port 1234   

                     System.out.println("Waiting for client on Port: "+server.getLocalPort() );       

                      Socket sock=server.accept();   //Accepts the connection from clients through ServerSocket         

                       PrintWriter out = new PrintWriter(sock.getOutputStream(), true);   

                          BufferedReader in =  new BufferedReader (new InputStreamReader  (sock.getInputStream()));     

                            String inputLine;    

                             while ((inputLine=in .readLine()) != null){   //Read the message from client                

                                        System.out.println("Received Client: " + inputLine);   

                                         out.println(inputLine );  //Send back to sender a response          }                          if (sock ==null) { return; }                  catch (IOException e){   printWriter ("Exception writing from client",e)}                    finally{               sock .close();                     PrintWriter(out).close();                 InputStreamReader(in ).close(): 

}                        //Handling exception and closing the connection.    `    });         }} `;             catch (IOException e){println("Error in communication: "+ e) }              SocketServer   };}})}})catch Exception ex {printStackTrace();}}}  `