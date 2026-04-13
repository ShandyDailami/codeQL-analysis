import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_37892_SocketServer_A08 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations such as integrity check
                // For the sake of the example, we'll use a dummy integrity check
                if (checkIntegrity(socket)) {
                    handleConnection(socket);
                } else {
                    closeConnection(socket);
                    System.out.println("Dropped connection from " + socket.getRemoteSocketAddress() + " due to integrity check failure");
                }
            } catch (IOException e) {
                e.printStackTrace();
                server.close();
            }
        }
    }

    private static boolean checkIntegrity(Socket socket) {
        // Perform integrity check here. For the sake of example, we'll just return true
        return true;
    }

    private static void handleConnection(Socket socket) {
        // Handle the connection here. For the sake of example, we'll just print the remote address
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello, you connected to " + socket.getRemoteSocketAddress());

        // Initiate I/O operations here
    }

    private static void closeConnection(Socket socket) {
        // Close the connection here. For the sake of example, we'll just print a message
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}