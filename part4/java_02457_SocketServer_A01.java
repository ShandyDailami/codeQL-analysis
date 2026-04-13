import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02457_SocketServer_A01 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;
    private static boolean running = true;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("Server started on port 6666.");

            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from " + clientSocket.getRemoteSocketAddress());
                Writer writer = new OutputStreamWriter(clientSocket.getOutputStream());
                writer.write("Welcome to the server!\n");
                writer.flush();
                executor.execute(new SocketHandler(clientSocket));
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            running = false;
            executor.shutdown();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_02457_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    // Simple echo server.
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Echo: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}