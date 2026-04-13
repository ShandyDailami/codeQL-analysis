import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_29168_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_29168_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate some work being done by the client
                    Thread.sleep(5000);

                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Thank you for connecting");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}