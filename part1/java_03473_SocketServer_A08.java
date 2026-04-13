import java.io.*;
import java.net.*;
import java.util.*;

public class java_03473_SocketServer_A08 {

    private static final String SERVER_STREAM = "server_stream";
    private static final String CLIENT_STREAM = "client_stream";
    private static Socket socket;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Message received from client: " + message);

                // Encrypt the message
                byte[] encrypted = encrypt(message.getBytes());

                // Send encrypted message
                out.writeUTF(new String(encrypted));

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static byte[] encrypt(byte[] message) {
        // Simple encryption - just replace each byte with the byte incremented by 3
        byte[] encrypted = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            encrypted[i] = (byte)(message[i] + 3);
        }
        return encrypted;
    }
}