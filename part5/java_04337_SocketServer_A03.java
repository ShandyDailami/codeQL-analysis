import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04337_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(5000);
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());
                ServerHandler handler = new ServerHandler(socket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        server.close();
        executor.shutdown();
    }

    private static class ServerHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_04337_SocketServer_A03(Socket socket) {
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
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}