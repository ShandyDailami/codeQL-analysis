import java.io.*;
import java.net.*;

public class java_19486_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for a client to connect...");

        Socket socket = serverSocket.accept();
        System.out.println("Client has connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        // Reading client's message
        String message = dataInputStream.readUTF();
        System.out.println("Received: " + message);

        // Sending response
        String response = "Hello, client!";
        dataOutputStream.writeUTF(response);
        System.out.println("Sent: " + response);

        socket.close();
        serverSocket.close();
    }
}