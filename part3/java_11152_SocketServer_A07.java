import java.io.*;
import java.net.*;

public class java_11152_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for a client...");

            Socket socket = serverSocket.accept();
            System.out.println("Connected to client");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Authenticate client
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            if ("A07_AuthFailure".equals(clientMessage)) {
                // If authentication fails, send a response
                dataOutputStream.writeUTF("Authentication failure");
                dataOutputStream.flush();
            } else {
                // If authentication succeeds, send a response
                dataOutputStream.writeUTF("Authentication successful");
                dataOutputStream.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}