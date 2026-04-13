import java.io.*;
import java.net.*;

public class java_21925_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started, waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String clientMessage;
        while ((clientMessage = input.readUTF()) != null) {
            System.out.println("Client says: " + clientMessage);

            // This is a place for a security-sensitive operation.
            // In this case, we're simply echoing back the message.
            String serverMessage = clientMessage;

            output.writeUTF(serverMessage);
            output.flush();
        }

        socket.close();
    }
}