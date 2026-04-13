import java.net.*;
import java.io.*;

public class java_12371_SocketServer_A03 {
    private static final int SERVER_PORT = 4445;
    private static final String SERVER_ADDRESS = "localhost";
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(SERVER_PORT, InetAddress.getByName(SERVER_ADDRESS));
        socket.setReuseAddress(true);

        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        System.out.println("Server is listening on port " + SERVER_PORT);

        while (true) {
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + message);

            // Process the message (e.g., sanitize and validate input)
            // ...

            String response = "Processed message: " + message;
            byte[] responseBytes = response.getBytes();
            packet = new DatagramPacket(responseBytes, responseBytes.length, packet.getSocketAddress());
            socket.send(packet);
        }
    }
}