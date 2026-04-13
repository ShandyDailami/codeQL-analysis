import java.io.*;

import java.net.*;

  

public class java_50763_SocketServer_A01 {     // Server Program starts here (Client program is in another file)   

 public static void main(String args[]){     

          try{       

              @SuppressWarnings("resource") ServerSocket welcomeSocket = new ServerSocket(6789); 

               System.out.println("\nServer Started at Port:  6789");                 

                while (true) {    // infinite loop to ensure server is running until we break the program     

                    Socket connectionToClient = welcomeSocket.accept();          

                     System.out.println("Connection Established with : " +connectionToClient.getRemoteSocketAddress());             

                      DataInputStream inFromClient = new DataInputStream(connectionToClient.getInputStream());    // reading data from client  and sending to server       

                       String message=inFromClient.readUTF();      System.out.println("\nMessage Received by Server: " +message);             if (message .equals("Exit")) {break;}           else{                                              DataOutputStream outToClient = new DataOutputStream(connectionToClient.getOutputStream()); 

                  // writing data to client from server            String answer="Hello Client, you entered -> "+ message;          System.out.println("\nMessage Send By Server:   " +answer);             outToClient .writeUTF (answer) ;                   }                                                                               try { welcomeSocket.close();} catch(Exception e){ // closing the socket and catching any exception if occurs    

                    }}       

           }catch (IOException e ){          System.out.println("Error in Connection" +e);      return;   }  };       public static void main1(String args[]) {    try         @SuppressWarnings("resource") Socket clientSocket = new                     java.net.Socket ("localhost",6789 );          DataOutputStream outToServer  =new                                        DataOutputStream (clientSocket .getOutputStream());                  String userInput="Hello Server, you entered -> ";               System.out.println("\nMessage Send By Client:  " +userInput);           outToServer .writeUTF(userInput) ;                   try { clientSocket .close();} catch       (Exception e){ // closing the socket and catching any exception if occurs    

                    return;    }} }});      System.out.println("\nStopped");   };  });`};