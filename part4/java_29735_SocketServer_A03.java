import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class java_29735_SocketServer_A03 {
    private DatagramSocket socket;

    public java_29735_SocketServer_A03(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void startServer() {
        byte[] buf = new byte[256];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        while (true) {
            try {
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);

                // Here you could handle the message and potentially send a response
                // For simplicity, we'll just echo back the message
                String response = message;
                byte[] bufResponse = response.getBytes();
                DatagramPacket packetResponse = new DatagramPacket(bufResponse, bufResponse.length, packet.getSocketAddress());
                socket.send(packetResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SocketException {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}