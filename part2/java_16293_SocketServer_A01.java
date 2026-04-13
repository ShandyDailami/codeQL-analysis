import java.io.*;
import java.net.*;
import java.util.*;

public class java_16293_SocketServer_A01 {
    private static List<String> messages = new ArrayList<>();
    private static int nextMessageId = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // create a new thread for handling each client
            new ClientHandler(clientSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_16293_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    if (message.equals("close")) {
                        System.out.println("Closing connection");
                        close();
                        break;
                    }

                    // simulate a security-sensitive operation
                    String response = "Server response: " + message;
                    writer.println(response);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void close() {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}