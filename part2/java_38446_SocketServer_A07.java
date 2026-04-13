import java.io.*;
import java.net.*;
import java.util.*;

public class java_38446_SocketServer_A07 {

    private static final int PORT = 8080;
    private static List<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                clients.add(out);

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_38446_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;

                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Implement authentication failure here.
                    // This is just a placeholder.
                    if (message.equals("fail")) {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.println("Authentication failed. Please try again.");
                        clients.remove(out);
                        break;
                    }

                    for (PrintWriter client : clients) {
                        client.println(message);
                    }
                }

                clients.remove(socket);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}