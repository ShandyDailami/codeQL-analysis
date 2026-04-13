import java.io.*;
import java.net.*;
import java.util.*;

public class java_16307_SocketServer_A03 {

    private static final int PORT = 5000;
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            clients.add(client);

            new Handler(client).start();
        }
    }

    private static class Handler extends Thread {
        Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_16307_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = reader.readLine();
                    if (message == null) {
                        closeConnection();
                    } else {
                        // Process the message (e.g., for logging)
                        System.out.println("Received: " + message);

                        // Echo the message back to the client
                        writer.println(message);
                    }
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null) socket.close();

                clients.remove(this);
            } catch (IOException e) {}
        }
    }
}