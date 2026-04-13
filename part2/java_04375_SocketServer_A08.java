import java.io.*;
import java.net.*;

public class java_04375_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());

            socket = serverSocket.accept();
            System.out.println("Connection established with " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Received message: " + message);

            String response = "Server received your message: " + message;
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();

            serverSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}