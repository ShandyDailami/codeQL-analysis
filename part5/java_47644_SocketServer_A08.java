import java.io.*;  // Importing Input/Output Streams, Socket Classes etc..  

import java.net.*;  // Including ServerSocket Class only for creating servers...   

public class java_47644_SocketServer_A08 {    

 public static void main(String[] args) throws IOException{      

        System.out.println("Vanilla Java TCP Echo Service Started...");     

         int port = 6034;  // specify the local Port number...   

                ServerSocket server = new ServerSocket (port,128 );  

          while(true) {    

             Socket client=server.accept();//Accepts incoming connection ...     

                      System.out.println("Connection established with "+client);       //Print message to confirm successful acceptance...   

                         PrintWriter out = new PrintWriter ( 

                          client . getOutputStream(),true );  

                              BufferedReader in =  new BufferedReader(new InputStreamReader(client.getInputStream()));     

                    String inputLine;    

                     while ((inputLine=in.readLine())!=null){    //Read a line from the socket.. 

                          System.out.println("Echoing "+inputline);   #Print received message back to client...      

                               out.println( inputLine );      #write echo string and flushing output stream ...    

                     }                    server.close(); //Close all the resources at end of program  ..    break;         

             }                      catch (IOException e){ System . err . println (" Error accepting connection from " + client);   return;}              }}