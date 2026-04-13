import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_14318_SocketServer_A01 {

    private static final int PORT = 6789;
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");
                    handleClient(socket);
                } catch (Exception ex) {
                    System.out.println("Error in handling client: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_14318_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Error in creating input/output streams: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // Assume this is a request for a secure operation.
                    // If not, it's a simple echo.
                    writer.println("Server says: " + request);
                    writer.flush();
                }
            } catch (IOException ex) {
                System.out.println("Error in reading from client: " + ex.getMessage());
                ex.printStackTrace();
            }
            finally {
                socketDisconnect();
            }
        }

        private void socketDisconnect() {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error in closing socket: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}