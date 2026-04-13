import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15256_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket
        ServerSocket serverSocket = new ServerSocket();

        // Bind the ServerSocket to a specific port
        serverSocket.bind(new InetSocketAddress(8080));

        System.out.println("Server is listening on port 8080...");

        // Infinite loop to accept client connections
        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Create a new thread for each client
            new ClientHandler(clientSocket).start();
        }
    }

    // Inner class for handling each client's request
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_15256_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Here you can add your logic for handling client requests
            // But please note, it's not recommended to use any standard libraries
            // for security sensitive operations like handling SOCKS connections
            // The focus here is on the code structure and not on the actual security

            // Here is a simple example of a SOCKS server
            // The actual SOCKS protocol is more complex and involves authentication
            // But this should give you a basic understanding of how to use Java's standard socket libraries
            // This example does not include any security measures like encryption or authentication

            try {
                // Send a simple response to the client
                socket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
                socket.getOutputStream().write("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
                socket.getOutputStream().write("\r\n".getBytes());
                socket.getOutputStream().write("This is a SOCKS server".getBytes());
                socket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}