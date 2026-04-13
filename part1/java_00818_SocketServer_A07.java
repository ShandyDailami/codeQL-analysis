import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_00818_SocketServer_A07 {

    private static final String SERVER_NAME = "SecureSocketServer";
    private static final int PORT = 12345;
    private static final String AUTHENTICATED_USER_ID = "A07_AuthFailure";

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at " + new Date());

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + new Date());

                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_00818_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String clientMessage;

            try {
                while ((clientMessage = reader.readLine()) != null) {
                    if (clientMessage.equals(AUTHENTICATED_USER_ID)) {
                        writer.println("Authenticated, please enter your message");
                        writer.flush();
                        break;
                    } else {
                        System.out.println("Invalid user ID received from " + socket.getRemoteSocketAddress() + ". Closing connection");
                        socket.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}