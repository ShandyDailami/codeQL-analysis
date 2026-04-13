import java.net.ServerSocket;
import java.net.Socket;

public class java_26085_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        // Create a new ServerSocket that listens on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server is listening on port 1234...");

        // Enter an infinite loop so that it can accept incoming connections
        while (true) {
            // Accept a new connection
            Socket socket = serverSocket.accept();

            // Create a new thread to handle this client
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        // Create a new InputStream from the socket
        // and a new BufferedReader from it
        // and a new PrintWriter from the socket
        // to read and write data from/to the client
        // and to handle any errors that occur
    }
}