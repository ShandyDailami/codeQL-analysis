import java.io.*;
import java.net.*;

public class java_22424_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create the Server Socket
            server = new ServerSocket(5000);
            System.out.println("Waiting for client connection... ");

            // Accept a client socket
            socket = server.accept();
            System.out.println("Client connected...");

            // Create InputStream and OutputStream for communication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to client
            out.writeUTF("Welcome to the server!");

            String messageFromClient;

            // Loop to receive message from client
            while ((messageFromClient = in.readUTF()) != null) {
                System.out.println("Received: " + messageFromClient);

                // If message is "quit", close the connection
                if (messageFromClient.equals("quit")) {
                    socket.close();
                    server.close();
                }
           
                // Else, send a response message back to client
                else {
                    out.writeUTF("Thank you for connecting to the server!");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Close the connection
            try {
                socket.close();
                server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}