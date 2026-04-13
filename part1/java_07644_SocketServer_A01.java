import java.io.*;
import java.net.*;

public class java_07644_SocketServer_A01 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client on port "
                    + serverSocket.getLocalPort() + "...");

            socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to the client
            out.writeUTF("Welcome to the server! You connected to port " +
                    serverSocket.getLocalPort() + ".");

            // Handle multiple clients by reading from and writing to the socket
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Break the loop if client sends 'exit'
                if (message.equals("exit")) break;

                // Respond with a message
                String response = "Server says: " + message;
                out.writeUTF(response);
            }

            // Close the connection
            out.close();
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
       
        }
    }
}