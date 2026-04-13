import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_08601_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Use SSL if enabled (replace 'false' with 'true')
        boolean ssl = false;

        ServerSocket server = null;
        if (ssl) {
            server = (SSLServerSocket) new SSLServerSocket(PORT);
        } else {
            server = new ServerSocket(PORT);
        }

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread to handle communication with the client
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_08601_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle communication with the client
            // For simplicity, just echo back the received data
            try (socket;
                 Socket newSocket = (socket.isConnected()) ? socket : (SSLSocket) socket.getInputStream()){

                byte[] bytes = new byte[1024];
                int length;
                while ((length = newSocket.getInputStream().read(bytes)) != -1) {
                    newSocket.getOutputStream().write(bytes, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}