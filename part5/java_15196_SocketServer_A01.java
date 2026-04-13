import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_15196_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, InterruptedException {
        serverSocket = new ServerSocket(8080);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            ServerHandler handler = new ServerHandler(socket);
            executor.execute(handler);
        }
    }

    static class ServerHandler extends Thread {
        private Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_15196_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // This is where we would handle the message, for example, by responding to it.
                    // For simplicity, we'll just respond with the same message back.
                    writer.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}