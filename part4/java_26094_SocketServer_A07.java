import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26094_SocketServer_A07 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            Handler handler = new Handler(socket);
            executor.submit(handler);
        }
    }

    static class Handler implements Runnable {
        private Socket socket;

        public java_26094_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);

                    if (message.equals("exit")) {
                        socket.close();
                        return;
                    }

                    String response = handleMessage(message);
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream, true);
                    writer.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String handleMessage(String message) {
            // Simulate authentication failure
            if (message.equals("fail")) {
                return "Authentication failed. Please try again.";
            }

            // If message was not "fail", simulate a successful authentication
            if (message.equals("success")) {
                return "Authentication successful.";
            }

            return "Invalid message.";
        }
    }
}