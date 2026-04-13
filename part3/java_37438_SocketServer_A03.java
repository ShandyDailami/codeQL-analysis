import java.io.*;
import java.net.*;
import java.util.*;

public class java_37438_SocketServer_A03 {

    // A list of all the clients connected to this server.
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle this client.
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This is a simple thread that handles a single client.
    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_37438_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received: " + line);

                    // Simple echo server.
                    out.println("Server echo: " + line);
                    out.flush();
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            clients.remove(socket);
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                // Ignore close errors.
            }
            System.out.println("Client disconnected: " + socket.getRemoteSocketAddress());
        }
    }
}