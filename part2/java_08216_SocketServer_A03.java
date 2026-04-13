import java.io.*;
import java.net.*;
import java.util.*;

public class java_08216_SocketServer_A03 {
    private static final int PORT = 4445;
    private static Set<Writer> writers = Collections.newSet();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writers.add(writer);

            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_08216_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                handleClient(socket.getInputStream());
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            }
        }

        private void handleClient(InputStream input) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message;

            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                for (Writer writer : writers) {
                    writer.write(message);
                    writer.write("\n");
                    writer.flush();
                }
            }
        }
    }
}