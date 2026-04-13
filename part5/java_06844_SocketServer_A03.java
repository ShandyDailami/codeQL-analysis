import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;

public class java_06844_SocketServer_A03 {
    private static final int SERVER_PORT = 4446;
    private static final String SERVER_MESSAGE = "Hello, Server!";

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);
            System.out.println("Server started on port: " + SERVER_PORT);

            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + received);

                byte[] sendBytes = SERVER_MESSAGE.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBytes, sendBytes.length, packet.getSocketAddress());
                socket.send(sendPacket);
            }
        } catch (SocketException e) {
            System.err.println("SocketException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }
}