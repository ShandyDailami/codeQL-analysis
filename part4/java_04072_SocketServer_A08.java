import java.io.*;
import java.net.*;

public class java_04072_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Waiting for client connection...");

            socket = serverSocket.accept();
            System.out.println("Client connected successfully!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage, serverMessage;

            while (true) {
                clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                serverMessage = "Server says: " + clientMessage;
                out.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}