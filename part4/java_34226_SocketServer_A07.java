import java.io.*;
import java.net.*;

public class java_34226_SocketServer_A07 {

    public static void main(String[] args) {

        // Server Socket
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                // Handshake
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established");
                System.out.println("Client is connected");

                // Data Transfer
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientMsg = in.readUTF();
                System.out.println("Client says: " + clientMsg);

                // Authentication (Assuming A07_AuthFailure)
                String authKey = in.readUTF();
                if ("A07_AuthFailure".equals(authKey)) {
                    out.writeUTF("Authentication failed");
                    System.out.println("Authentication failed");
                } else {
                    out.writeUTF("Authentication successful");
                    System.out.println("Authentication successful");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}