import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_10584_SocketServer_A07 {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(new ClientHandler(socket));
            } catch (Exception e) {
                server.close();
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_10584_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {

            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println("Echo: " + message);
                }

            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Error closing connection: " + ex.getMessage());
                }
            }
        }
    }
}