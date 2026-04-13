import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33814_SocketServer_A08 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted a new client");
            Handler handler = new Handler(clientSocket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    if (message.equals("close")) {
                        writer.println("Connection closed");
                        break;
                    }

                    // Here we use the client's input as the message for the server
                    // In a real-world application, this would be a more complex operation
                    // that includes additional security measures.
                    writer.println("Message sent back: " + message);
                }

                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}