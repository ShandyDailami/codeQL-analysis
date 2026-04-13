import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12127_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error while handling client " + e.getMessage());
       
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;

        public java_12127_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket.getInputStream()) {
                byte[] buffer = new byte[1024];
                int bytes = socket.getInputStream().read(buffer);
                String request = new String(buffer, 0, bytes);
                System.out.println("Received: " + request);

                if ("GET".equals(request.split(" ")[0])) {
                    socket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
                    socket.getOutputStream().write("Content-Type: text/html\r\n\r\n".getBytes());
                    socket.getOutputStream().write("<h1>Hello, World!</h1>".getBytes());
                    socket.getOutputStream().flush();
                }
            } catch (IOException e) {
                System.out.println("Error handling client " + e.getMessage());
            }
        }
    }
}