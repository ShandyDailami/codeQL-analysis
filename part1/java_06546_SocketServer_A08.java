import java.io.*;
import java.net.*;

public class java_06546_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 8189);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent message: " + serverMessage);

            socket.close();
        }
    }
}