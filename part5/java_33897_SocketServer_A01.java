import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33897_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = null;
        try {
            server = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                Writer writer = new OutputStreamWriter(socket.getOutputStream());
                writer.write("Connected\n");
                writer.flush();
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter writer;
        private BufferedReader reader;

        public java_33897_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                this.writer = new PrintWriter(socket.getOutputStream(), true);
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    writer.println("Server: " + message);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}