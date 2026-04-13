import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22027_SocketServer_A03 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_22027_SocketServer_A03(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server is running on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client at " + clientSocket.getRemoteSocketAddress());
                executor.execute(new VanillaClientHandler(clientSocket));
            } catch (IOException e) {
                System.err.println("Failed to accept new client at " + e);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new VanillaServer(8080).start();
    }

    class VanillaClientHandler implements Runnable {

        private final Socket clientSocket;

        public java_22027_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (OutputStream out = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
                 InputStream in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()))) {

                String request;
                while ((request = in.readLine()) != null) {
                    out.write("Received: " + request + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}