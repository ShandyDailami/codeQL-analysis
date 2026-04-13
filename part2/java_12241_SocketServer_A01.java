import java.io.*;
import java.net.*;

public class java_12241_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                OutputStream outToClient = clientSocket.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToClient);

                // Send a message to the client
                out.writeUTF("Hello client, you are connected to the server!");

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}