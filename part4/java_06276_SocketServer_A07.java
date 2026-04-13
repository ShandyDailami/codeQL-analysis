import java.io.*;
import java.net.*;

public class java_06276_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Perform security-sensitive operations related to A07_AuthFailure

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Message received!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            socket.close();
        }
    }
}