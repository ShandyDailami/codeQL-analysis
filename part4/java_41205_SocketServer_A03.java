import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_41205_SocketServer_A03 {
    private final ExecutorService executorService;
    private final ServerSocket serverSocket;

    public java_41205_SocketServer_A03(int port) throws IOException {
        this.executorService = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + ".");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            executorService.execute(new SocketHandler(clientSocket));
        }
    }

    private class SocketHandler implements Runnable {
        private final Socket socket;

        public java_41205_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                byte[] bytes = new byte[1024];
                int bytesRead;

                while ((bytesRead = input.read(bytes)) != -1) {
                    handleInput(new String(bytes, 0, bytesRead));
                    output.write(bytes, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void handleInput(String input) {
            // This is a very basic form of injection prevention.
            // The input string is used as is, without any sanitization or validation.
            // This is a very simplified example, and real-world use of this would be much more complex.
            System.out.println("Received: " + input);
        }
    }

    public static void main(String[] args) throws IOException {
        VanillaJavaSocketServer server = new VanillaJavaSocketServer(8080);
        server.start();
    }
}