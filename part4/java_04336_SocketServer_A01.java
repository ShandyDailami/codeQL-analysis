import java.io.*;
import java.net.*;
import java.util.*;

public class java_04336_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running and waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientRequest = in.readUTF();
                System.out.println("Client says: " + clientRequest);

                // Authenticate the client.
                if (clientRequest.equals("Hello")) {
                    out.writeUTF("Authentication successful.");
                } else {
                    out.writeUTF("Authentication failed.");
                    socket.close();
                    continue;
                }

                // Send a response back to the client.
                out.writeUTF("Server says: Hello, client!");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}