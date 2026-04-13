import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;

public class java_27840_SocketServer_A03 {
    private static final int SERVER_PORT = 4445;
    private static final String SERVER_HOST = "localhost";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        // Create a datagram socket
        DatagramSocket socket = new DatagramSocket(SERVER_PORT, null);

        // Set socket to non-blocking mode
        socket.setSoTimeout(5000);

        byte[] buffer = new byte[BUFFER_SIZE];

        while (true) {
            // Create a datagram packet
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            try {
                // Try to receive a packet
                socket.receive(packet);

                // Handle the packet
                handlePacket(packet);
            } catch (SocketTimeoutException e) {
                System.out.println("No packet received within 5 seconds.");
            }
        }
    }

    private static void handlePacket(DatagramPacket packet) {
        // Handle the packet here, for example, check if it's a valid connection request
        String request = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + request);

        // Send a response
        String response = "Accepted connection from " + packet.getAddress().getHostAddress();
        byte[] bytes = response.getBytes(0, response.length());
        DatagramPacket responsePacket = new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort());
        socket.send(responsePacket);
    }
}