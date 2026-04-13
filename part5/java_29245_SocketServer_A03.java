import java.io.*;
import java.net.*;
import java.util.*;

public class java_29245_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(3333);
        System.out.println("Server is listening on port 3333");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected from " + client.getRemoteSocketAddress());
            clients.add(client);

            Thread thread = new Thread(new SocketHandler(client));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_29245_SocketServer_A03(Socket socket) {
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
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // TODO: Implement real security-sensitive operations related to A03_Injection here.
                    // For now, just echo the message back.
                    out.println(message);
                }
            } catch (IOException e) {
                close();
            }
        }

        public void close() {
            clients.remove(socket);
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore
            }
            System.out.println("Client " + socket.getRemoteSocketAddress() + " disconnected.");
        }
    }
}