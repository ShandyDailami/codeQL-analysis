import java.io.*;
import java.net.*;

public class java_24465_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);

            socket.close();
        }
    }
}