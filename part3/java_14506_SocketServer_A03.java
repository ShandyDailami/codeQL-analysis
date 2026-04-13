import java.io.*;
import java.net.*;
import java.util.*;

public class java_14506_SocketServer_A03 {

    // This is the port the server will listen on.
    private static final int SERVER_PORT = 8080;

    private static Set<Socket> connectedClients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT + ".");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected from " + client.getRemoteSocketAddress());

            connectedClients.add(client);

            new HandlerThread(client).start();
        }
    }

    private static class HandlerThread extends Thread {
        private Socket client;

        public java_14506_SocketServer_A03(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                OutputStream out = new BufferedOutputStream(client.getOutputStream());
                InputStream in = new BufferedInputStream(client.getInputStream());

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    // Pass the message to all connected clients
                    for (Socket socket : connectedClients) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                connectedClients.remove(client);
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}