import java.io.*;
import java.net.*;

public class java_00719_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080); // 8080 is the port number for the server
            System.out.println("Server started on port: 8080");

            while(true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // create input stream and output stream
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while((clientMessage = in.readLine()) != null) {
                    System.out.println("Received client message: " + clientMessage);

                    // send back a response to the client
                    String response = "Hello client, your message was: " + clientMessage;
                    out.println(response);
                }

                socket.close();
            }
        } catch(IOException e) {
            System.out.println("Error in communication: " + e.getMessage());
        }
    }
}