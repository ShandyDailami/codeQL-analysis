import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29392_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080, 100);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create two threads to handle the two kinds of requests separately
            new HandleRequest(socket).start();
        }
    }

    private static class HandleRequest extends Thread {
        private final Socket socket;

        public java_29392_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead = in.read(buffer);
                String message = new String(buffer, 0, bytesRead);

                if (message.startsWith("GET")) {
                    // If the client sends a "GET / HTTP/1.1", accept it.
                    // Otherwise, deny access.
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                } else {
                    out.write("HTTP/1.1 403 Forbidden\r\n\r\n".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}