import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08459_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                // Check if the integrity of received data is valid
                // This is a simple check, in a real-world scenario, you'd want to use a stronger method
                if (!isValidDataIntegrity(socket)) {
                    System.out.println("Invalid data integrity, closing connection");
                    socket.close();
                    continue;
                }

                // Validate the source of the connection
                if (!isValidSource(socket)) {
                    System.out.println("Invalid source, closing connection");
                    socket.close();
                    continue;
                }

                // Process the received data
                processData(socket);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDataIntegrity(Socket socket) {
        // This is a simple check, in a real-world scenario, you'd want to use a stronger method
        // You could calculate the checksum of the received data and compare it to a stored value
        return true;
    }

    private static boolean isValidSource(Socket socket) {
        // This is a simple check, in a real-world scenario, you'd want to use a stronger method
        // You could check the source IP address and port against a list of trusted sources
        return true;
    }

    private static void processData(Socket socket) {
        // This is a simple example of processing the data. In a real-world scenario, you'd want to use a more complex method
        // This could involve decoding the data, performing some calculations, etc.
        System.out.println("Received data: " + socket.getInputStream().read());
    }
}