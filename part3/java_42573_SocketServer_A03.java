import java.io.*;   // Import required classes   

import java.net.*;  // For ServerSocket, Socket class java_42573_SocketServer_A03 class MyServer {     

        

        public static void main(String[] args) throws Exception{         

            int port = 1234;// Changed to a default safe one  

            

           try (ServerSocket server = new ServerSocket(port))  // Closing the socket on exit using Try-With resources.   

                {     

                    System.out.println("Waiting for client connection...");    

                        Socket sock=server.accept();  

                        

                            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);  //true is the autoflush property   

                             BufferedReader in =new BufferedReader(     

                                         new InputStreamReader(    

                                                  sock.getInputStream()));      

                              String inputLin;  

                                     while ( (inputlin=in .readline()) !=  null) {         

                                        System.out.println("Received client: " + inputLine);  // This line is security sensitive and should be done via exceptions not printed on console    }      Strings are read from the socket, so no risk here     out.close();   sock.close() ;}                 catch (IOException e) {e .printStackTrace( );}}       

                });  // End of Try-With resources closing all opened streams at once and preventing resource leaks            }      if you use this for a client to read then it is safe here, but keep reading from the socket until an end command arrives.    }}   For Socket programming in detail refer: https://www.geeksforgeeks.org/socket-programming-java/