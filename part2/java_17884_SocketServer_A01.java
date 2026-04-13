import java.io.*;
import java.net.*;

public class java_17884_SocketServer_A01 {

    private static final String HOST_NAME = "localhost";
    private static final int PORT = 4446;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, " + message;
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}