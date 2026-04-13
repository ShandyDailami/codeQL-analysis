import java.io.*;
import java.net.*;

public class java_06073_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());

                // Check if the client's IP address is blocked
                String clientIP = socket.getRemoteSocketAddress().toString().substring(socket.getRemoteSocketAddress().toString().lastIndexOf("/") + 1);
                if ("127.0.0.1".equals(clientIP)) {
                    System.out.println("Blocked client: " + clientIP);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Blocked client");
                    socket.close();
                } else {
                    // Process the request
                    new Thread(new SocketRequestHandler(socket)).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* unable to do anything */ }
            }
        }
    }

    private static class SocketRequestHandler implements Runnable {
        private final Socket socket;
        public java_06073_SocketServer_A01(Socket socket) { this.socket = socket; }
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("OK: " + request);
                }
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}