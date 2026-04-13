import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31966_SocketServer_A08 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket socket;

        public java_31966_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message = reader.readLine();
                System.out.println("Received: " + message);

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Hello, Client!");

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}