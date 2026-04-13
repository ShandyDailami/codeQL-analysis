import java.net.*;
import java.io.*;

public class java_04128_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is running on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message from client: " + message);

            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);

            clientSocket.close();
       
        }
    }
}