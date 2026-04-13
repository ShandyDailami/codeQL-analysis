import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class java_33906_SocketServer_A07 {
    private static final int PORT = 4446;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Server started on port " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);

                // Implement A07_AuthFailure security requirement here
                // For simplicity, let's just respond with a "Hello" message
                String response = "Hello";
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, packet.getSocketAddress());
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}