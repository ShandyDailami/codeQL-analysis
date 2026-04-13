import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31612_SocketServer_A01 {
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // Bind the server socket to a port
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server is running on port " + serverSocket.getLocalPort());

            // Listen for connections
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connected to: " + socket.getRemoteSocketAddress());

                // Create reader and writer for the client socket
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Receive and echo messages back to the client
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                }

                // Close the connection
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}