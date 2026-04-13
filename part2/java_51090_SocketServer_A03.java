import java.io.*;  // Import required classes for sockets and input-output streams  

import java.net.*;  // To use ServerSocket, Socket   

    

public class java_51090_SocketServer_A03 {     

       public static void main(String[] args) throws IOException{         

           int port = 6001;         # The actual Port number of your server  

            try (ServerSocket server = new ServerSocket(port)) {  // Binds the socket to a specific local-port and listens for incoming connections.   

                System.out.println("Waiting on port " + port);     

                     while (true) {               # Infinite loop, waiting until client connects                  

                        Socket connection = server.accept();  // Accept a new socket when one arrives  

                            try( PrintWriter out =  new PrintWriter(connection.getOutputStream(), true)){   

                                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));    

                                   String inputLine;           # To read the message from client side  and print it back to them  

                                       while ((inputLine = in.readLine()) != null) {      // If a line is available, then process         

                                              System.out.println("Received: " + inputLine);   

                                                }                  # Close the socket resources after use            

                                         connection.close();                   });    

                    }} catch (IOException e){              

                        // Handle exceptions here or re-launch server on exception occurrence  

                System.out.println("Exception: " +e);  };                     
}      # Closing the Server Socket in case of any Exception             }