import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08872_SocketServer_A01 {

    // Our server's port number
    private static final int PORT_NUMBER = 8080;

    // The socket server
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        new SocketServer().start();
    }

    public void start() {
        try {
            // Create a server socket
            serverSocket = new ServerSocket();

            // Bind the server socket to a specific port
            serverSocket.bind(new InetSocketAddress(PORT_NUMBER));

            System.out.println("Server is listening on port " + PORT_NUMBER);

            while (true) {
                // Accept a connection
                Socket socket = serverSocket.accept();

                // Create a new thread to handle the client connection
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class SocketHandler implements Runnable {
        private Socket socket;

        public java_08872_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can add access control logic to prevent access to the server
            // for unauthorized clients
            if (!socket.getInetAddress().equals(serverSocket.getLocalSocketAddress())) {
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " has attempted to connect. Refusing connection.");
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Handle the client connection here
            }
        }
    }
}