import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33265_SocketServer_A03 {
    private static final String PASSWORD = "securePassword";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                InetAddress clientAddress = socket.getRemoteSocketAddress();
                System.out.println("Client IP address: " + clientAddress.getHostAddress());

                String clientPassword = authenticateClient(socket);

                if (clientPassword != null && clientPassword.equals(PASSWORD)) {
                    System.out.println("Authentication successful!");
                    // Handle the client here using the socket
                } else {
                    System.out.println("Authentication failed!");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String authenticateClient(Socket socket) {
        try {
            // Create a new input stream and read the password from the socket
            java.io.InputStream input = socket.getInputStream();
            byte[] buffer = new byte[1024];
            input.read(buffer);
            String password = new String(buffer, 0, input.available());
            return password;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}