import java.net.*;
import java.io.*;
import java.util.*;

public class java_39830_SocketServer_A07 {

    public static void main(String args[]) {
        Socket socket;
        ServerSocket serverSocket;

        try {
            // Create the server socket
            serverSocket = new ServerSocket(2401);

            System.out.println("Waiting for client on port: " +
                                serverSocket.getLocalPort() + "...");

            // Accept a client
            socket = serverSocket.accept();

            System.out.println("Just connected to " +
                                socket.getRemoteSocketAddress());

            // Get input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Handle client-server communication
            String message, response;
            while (true) {
                // Read from client
                message = dis.readUTF();
                System.out.println("Received: " + message);

                // Authentication Failure
                if (message.equals("authFailure")) {
                    response = "Auth Failure";
                } else {
                    response = "Unknown command";
                }

                // Send response back to client
                dos.writeUTF(response);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}