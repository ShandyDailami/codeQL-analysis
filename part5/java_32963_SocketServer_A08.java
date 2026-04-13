import java.net.*;
import java.io.*;
import java.util.Random;

public class java_32963_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Connected successfully");

            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_32963_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // do something with message...
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}