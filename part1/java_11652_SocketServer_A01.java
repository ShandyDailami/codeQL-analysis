import java.net.*;
import java.io.*;

public class java_11652_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            if (clientMessage.equals("exit")) {
                break;
            }

            output.writeUTF("Hello, Client!");
            output.flush();
            System.out.println("Server says: Hello, Client!");
        }

        serverSocket.close();
    }
}