import java.io.*;
import java.net.*;
import java.util.*;

public class java_16989_SocketServer_A07 {
    private static final int PORT = 1234;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New client connected at " + clientSocket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            clients.add(out);

            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_16989_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    for (PrintWriter client : clients) {
                        client.println(message);
                    }
                }

                clients.remove(clientSocket.getOutputStream());
                clientSocket.close();
            } catch (Exception e) {
                clients.remove(clientSocket.getOutputStream());
                clientSocket.close();
            }
        }
    }
}