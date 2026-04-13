import java.io.*;
import java.net.*;

public class java_04947_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientIP = socket.getRemoteSocketAddress().toString();

                if (clientIP.matches("^127\\.0\\.0\\.1$")) { // only accept connections from localhost
                    System.out.println("Client " + clientIP + " accepted");
                    dataOutputStream.writeUTF("Authentication successful");
                } else {
                    System.out.println("Client " + clientIP + " rejected");
                    dataOutputStream.writeUTF("Authentication failed");
               
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}