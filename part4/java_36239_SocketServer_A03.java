import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36239_SocketServer_A03 {
    private static ExecutorService executor;
    private static int port = 1234;

    public static void main(String[] args) throws IOException, InterruptedException {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            executor.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_36239_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Add your security-sensitive operations here

                    // Here is an example of sending back a response
                    out.println("Server received your message: " + message);
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}