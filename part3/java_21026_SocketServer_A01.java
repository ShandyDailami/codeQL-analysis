import java.net.*;

public class java_21026_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a datagram socket
            DatagramSocket socket = new DatagramSocket(12345);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Waiting for messages...");

            // Infinite loop to receive and print messages
            while (true) {
                socket.receive(packet); // Wait for a packet
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);
           
                // Send a response
                String response = "Server received: " + message;
                byte[] bytes = response.getBytes();
                socket.send(new DatagramPacket(bytes, bytes.length, packet.getSocketAddress()));
            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        }
    }
}