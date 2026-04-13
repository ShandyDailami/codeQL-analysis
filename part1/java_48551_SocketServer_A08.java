import java.io.*;  // Import necessary classes from Java's I/O package (InputStream, OutputStream) and sockets(Socket).  

                  /*Also import for the socket programming exceptions*/

import java.net.*;    

               

public class java_48551_SocketServer_A08 {   

 public static void main(String args[] ) throws IOException  // Main method to start server .

        {           System.out.println("Starting Server...");   /* Starting the listening socket with a port */         int port = 2488;     Socket s= null ;      try{                BufferedReader in = new BufferedReader(new InputStreamReader (System.in));  // Reading from standard input to send message back   

 {                    System.out.println("Enter your Message: ");         String str = in .readLine(); if ("exit".equalsIgnoreCase(str))                 s.close();   /* Closing the socket */                   }catch (IOException e){System.err.println(e);}  // Handling any exceptions that may occur during I/O operations    

                  try{                DataOutputStream out = new DataOutputStream(s .getOutputStream());    System.out.print("Enter your Message: ");   String sentance= in .readLine(); if ("exit".equalsIgnoreCase (sentance)) { s.close(); }  // Sending message to the client */                   else                    

{                                                                        out.writeBytes(sentance+'\n');     System.out.println("Message Sent Successfully");   }}catch (IOException e){System.err .println ("Exception Occurred while sending/receiving data" +e);}}  // Handling exceptions */   

}                                                                      /* Closing the server socket and terminating all active connections if possible*/     try{s= new Socket("127.0.0.1", port ); System.out .println ("Connected to Server");        DataInputStream in =new   // Receiving Message from client 

(DataInputStream ( s .getInputStream())) ;    }catch (IOException e){System.err .println ('Exception Occurred while sending/receiving data' +e);}}     try{while ((sentance=in..readLine()) !=  null) { System .out   // Printing the received message 

from client */println( sentance ); }}catch (IOException e){System.err    /* Exception Occurred while sending/receiving data' +e);}}     }       if ((str=s..readLine()) !=  null) { System .out   // Printing the send message from 

client */println( str ) ; }} catch (IOException e){System.err    /* Exception Occurred while sending/receiving data' +e);}}     }       s ..close();}      finally{s..close();}}}catch(){finally {if(!SocketServer.isBound() || !socket .isConnected()) System  

.outprintln ("Error in binding the port or connection already dropped by client");  try{(new SecureClient()).connect("127.0.0." +port, s);}}catch (IOException e){System..println(e)}}}      })};     /* End of Main method */