import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19219_SocketServer_A03 {

    private ExecutorService executor;
    private final int port;

    public java_19219_SocketServer_A03(int port) {
        this.port = port;
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executor.execute(new ConnectionHandler(clientSocket));
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private class ConnectionHandler implements Runnable {
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_19219_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        writer.println("Bye!");
                        break;
                    }
                    writer.println("Hello, " + message);
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        VanillaServer server = new VanillaServer(8080);
        server.start();
    }
}