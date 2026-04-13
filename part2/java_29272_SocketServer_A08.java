import java.io.*;
import java.net.*;

public class java_29272_SocketServer_A08 {
    private static final String QUIT = "quit";

    public static void main(String[] args) {
        int port = 1234; // the port number to listen to
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to: " + clientSocket.getRemoteSocketAddress());
                // Create new thread for each client
                new HandleClient(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port: " + port);
            System.exit(-1);
        }
    }

    private static class HandleClient extends Thread {
        private final Socket socket;

        public java_29272_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (OutputStream out = new BufferedOutputStream(socket.getOutputStream());
                 InputStream in = new BufferedInputStream(socket.getInputStream())) {

                byte[] bytes = new byte[1024];
                int length;
                while ((length = in.read(bytes)) != -1) {
                    // Send received data back to client
                    out.write(bytes, 0, length);
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + socket.getRemoteSocketAddress());
            }
        }
    }
}