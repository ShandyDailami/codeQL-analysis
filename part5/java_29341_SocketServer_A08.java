import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29341_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        // Create a new ServerSocket
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Wait for a client to connect
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A new client has connected");

                // Handle the client connection
                new HandleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Private class for handling the client connection
    private static class HandleClient extends Thread {
        private Socket clientSocket;

        public java_29341_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
            start();
        }

        @Override
        public void run() {
            // Process the client connection
            // For the sake of simplicity, let's just print the received data
            // and close the connection
            try {
                while ((clientSocket.getInputStream().read() != -1)) ;
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}