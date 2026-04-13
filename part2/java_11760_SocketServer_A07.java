import java.io.*;
import java.net.*;

public class java_11760_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Step 1: Create a ServerSocket
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started at port 5000");

            while (true) {
                // Step 2: Accept a client
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                // Step 3: Send a message
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Hello client, you are connected to server");

                // Step 4: Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}