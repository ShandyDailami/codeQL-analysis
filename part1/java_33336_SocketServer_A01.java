import java.io.*;
import java.net.*;

public class java_33336_SocketServer_A01 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Initialize the server socket
            serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000");

            while (true) {
                // Step 2: Wait for a client to connect
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Step 3: Handle the client communication
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Message received");
                System.out.println("Sent: Message received");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close the server socket
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}