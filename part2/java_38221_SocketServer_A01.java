import java.net.*;
import java.io.*;

public class java_38221_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                output.writeUTF("Connection closed");
                socket.close();
                System.out.println("Connection closed");
            } else {
                String response = "Hello, " + message;
                output.writeUTF(response);
            }
        }
    }
}