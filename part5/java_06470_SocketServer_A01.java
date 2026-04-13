import java.io.*;
import java.net.*;

public class java_06470_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        int port = 8080; // default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            String response = "Welcome to the server!";
            dos.writeUTF(response);

            // Close the connection
            socket.close();
       
            // End the program
            // System.exit(0);
        }
    }
}