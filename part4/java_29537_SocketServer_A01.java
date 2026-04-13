import java.net.*;
import java.io.*;

public class java_29537_SocketServer_A01 {
    private static final String DISCOVERY_NAME = "SecureServer";
    private static final int SERVER_PORT = 4445;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT, InetAddress.getByName(DISCOVERY_NAME));
            System.out.println("Server started on port " + SERVER_PORT + " with name " + DISCOVERY_NAME);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);

                // Here, you can implement code for A01_BrokenAccessControl related operations.
                // For example, you can check if the message contains sensitive information and block the client if it does.
                // However, since this is a simple example, we'll keep it simple and just print the received message.

                String response = "Server received: " + message;
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, packet.getSocketAddress());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}