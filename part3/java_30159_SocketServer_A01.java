import java.net.*;
import java.io.*;

public class java_30159_SocketServer_A01 {
    private static final int PORT = 1234;
    private static DatagramSocket socket;

    public static void main(String[] args) {
        try {
            // Create a datagram socket
            socket = new DatagramSocket(PORT);
            System.out.println("Socket created.");

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // Receive packet from client
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);

                // Security-sensitive operations
                if (message.contains("access")) {
                    System.out.println("Access denied.");
                    // Modify the message
                    message = "Access denied.";
                }

                // Send message back to client
                DatagramPacket replyPacket = new DatagramPacket(
                        message.getBytes(),
                        message.getBytes().length,
                        packet.getSocketAddress()
                );
                socket.send(replyPacket);
            }
        } catch (SocketException e) {
            socket.close();
            System.out.println("Socket closed.");
        }
    }
}