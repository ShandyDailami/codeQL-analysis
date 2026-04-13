import java.io.*;
import java.net.*;

public class java_00241_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // read the message from the client
            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            // send the message back to the client
            dataOutputStream.writeUTF("Hello, client, your message was received successfully! " + message);
            dataOutputStream.flush();

            socket.close();
        }
    }
}