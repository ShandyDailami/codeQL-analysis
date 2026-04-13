import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class java_24334_SocketServer_A08 {

    private DatagramSocket socket;
    private byte[] buffer;
    private int bufferSize;

    public java_24334_SocketServer_A08(int port) {
        try {
            socket = new DatagramSocket(port);
            bufferSize = 1024;
            buffer = new byte[bufferSize];
            System.out.println("Server is listening on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);

                // Send a response back to the client.
                String response = "Server responded to client: " + message;
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseBytes, 
                        responseBytes.length, 
                        packet.getSocketAddress());

                socket.send(responsePacket);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(5000);
        server.startServer();
    }
}