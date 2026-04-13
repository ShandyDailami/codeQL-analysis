import java.io.*;
import java.net.*;

public class java_33588_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for connections on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Client says: " + message);

            String response = "Hello, Client!";
            output.writeUTF(response);
            System.out.println("Server says: " + response);

            socket.close();
        }
    }
}