import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41728_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT + ".");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // spawn a new thread to handle the connection
            new HandleConnection(socket).start();
        }
    }

    static class HandleConnection extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        HandleConnection(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // here we are performing a basic form of injection
                    // it's not safe to do this on the server side without proper validation and sanitization
                    // as it can lead to Cross-Site Scripting (XSS) attacks
                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try { socket.close(); } catch (IOException e) { /* ignore */ }
                in = null;
                out = null;
            }
        }
    }
}