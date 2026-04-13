import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16408_SocketServer_A08 {

    private ExecutorService executor;

    public java_16408_SocketServer_A08(int port) {
        System.out.println("Starting server at port: " + port);
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            executor = Executors.newCachedThreadPool();
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted: " + socket.getRemoteSocketAddress());
                executor.execute(new SocketHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
            executor.shutdown();
        }
    }

    private class SocketHandler implements Runnable {
        private Socket socket;
        public java_16408_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Server received your message: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServerExample(8080);
    }
}