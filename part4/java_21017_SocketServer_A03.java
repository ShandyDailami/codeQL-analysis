import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21017_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            // Create a new thread for each client connection
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_21017_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Inject your security sensitive operation here
                    // For example, check if the message contains SQL injection or XSS attacks
                    // If it does, send a response back to the client
                    if (message.contains(";") || message.contains("'")) {
                        writer.println("Attempting to inject SQL or XSS, received a message from: " + socket.getRemoteSocketAddress());
                        writer.flush();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}