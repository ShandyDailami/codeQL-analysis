import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31974_SocketServer_A07 {

    private static ExecutorService executor = Executors.newFixedThreadPool(5);
    private static boolean running = true;

    public static void main(String[] args) {
        ServerSocket server = null;
        while (running) {
            try {
                server = new ServerSocket(5000);
                System.out.println("Server started on port 5000");
                while (running) {
                    try {
                        Socket socket = server.accept();
                        executor.execute(new ClientHandler(socket));
                    } catch (Exception e) {
                        running = false;
                        break;
                    }
                }
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public java_31974_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                if (message.equals("exit")) {
                    sendMessage("Connection closed by client");
                    break;
                }
                sendMessage("Message received: " + message);
            }
            closeConnection();
        }

        private String readMessage() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void sendMessage(String message) {
            try {
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void closeConnection() {
            try {
                reader.close();
                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}