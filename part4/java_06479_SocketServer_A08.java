import java.io.*;
import java.net.*;

public class java_06479_SocketServer_A08 {
    private static int port = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client accepted");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client!";
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}