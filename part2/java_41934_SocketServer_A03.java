import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41934_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to a port
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            // Listen for incoming client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_41934_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client connection
            try {
                // Read input from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = reader.readLine();

                // Echo the input back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("You said: " + input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}