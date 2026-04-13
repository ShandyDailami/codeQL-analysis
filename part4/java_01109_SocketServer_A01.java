import java.net.ServerSocket;
import java.net.Socket;

public class java_01109_SocketServer_A01 {
    private static final int PORT = 12345; // Port to listen on

    public static void main(String[] args) {
        // Step 1: Initialize Server Socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
        } catch (Exception e) {
            System.out.println("Server could not start. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // Step 2: Listen for client connections
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Step 3: Handle client connections
                // For simplicity, we'll just print out the message from the client
                // and simply close the connection. In a real-world application,
                // you'd also have to implement a Thread or use a separate
                // thread to handle the client connection.
                new HandlerThread(socket).start();
            } catch (Exception e) {
                System.out.println("Could not accept client connection. Exiting...");
                e.printStackTrace();
            }
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_01109_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Step 4: Handle client connection
            // Here, we'll just print out the message from the client
            // and simply close the connection. In a real-world application,
            // you'd also have to implement a BufferedReader to read
            // from the client, and a PrintWriter to send a response.
            System.out.println("Handling client connection...");

            // Close the socket here, to prevent the server from listening for more connections
            socket.close();
        } catch (Exception e) {
            System.out.println("Could not handle client connection. Exiting...");
            e.printStackTrace();
        }
    }
}