import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34483_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // Define the port for the server to listen on
        int port = 5000;

        // Create a new ServerSocket that listens on the specified port
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is listening on port " + port);

        // Infinite loop to accept new clients
        while (true) {
            // Accept a new client
            Socket socket = serverSocket.accept();

            // Get the client's IP address
            InetAddress clientAddress = socket.getInetAddress();

            System.out.println("Accepted connection from " + clientAddress.getHostAddress());

            // Handle the client's request here...

            // Close the socket
            socket.close();
        }
    }
}