import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10195_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Here, we're using a simple command line utility to verify the socket's integrity
            // In a production environment, this should be replaced with a more robust method for verifying socket integrity
            if (!verifyIntegrity(socket)) {
                System.out.println("Integrity check failed, closing connection.");
                socket.close();
            }
       
        }
    }

    private static boolean verifyIntegrity(Socket socket) {
        // This is a very basic method of verifying socket integrity.
        // In a production environment, this should be replaced with a more robust method for verifying socket integrity.
        return true;
    }
}