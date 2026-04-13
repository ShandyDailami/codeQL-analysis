import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11288_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // Start a new thread for each client
            Thread t = new Thread(new ClientHandler(client));
            t.start();
        }
    }

    // Inner class for handling each client
    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_11288_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Read and handle the request from the client
                // For the security-sensitive operations related to A01_BrokenAccessControl, 
                // you should implement methods to check the request and react appropriately.
                // For now, we'll just read and echo the request
                while ((clientSocket.getInputStream().read()) != -1) ;

                // Echo the response back to the client
                clientSocket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
                clientSocket.getOutputStream().write("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
                clientSocket.getOutputStream().write("\r\n".getBytes());
                clientSocket.getOutputStream().write("Hello, Client!".getBytes());

                clientSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}