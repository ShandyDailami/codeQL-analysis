import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08246_SocketServer_A08 {
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        executorService = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                Handler handler = new Handler(socket);
                executorService.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
           
                System.out.println("Client disconnected");
            }
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_08246_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Process the message

                    // Send response
                    writer.println("Message received");
                }

                writer.close();
                reader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}