import java.io.*;
import java.net.*;
import java.util.*;

public class java_05454_SocketServer_A01 {
    private ArrayList<Socket> clients;
    private ServerSocket serverSocket;

    public java_05454_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clients = new ArrayList<>();
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort());

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clients.add(clientSocket);

            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_05454_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Add security-sensitive operations here

                    for (Socket client : clients) {
                        try {
                            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                            writer.println("Server: " + message);
                        } catch (IOException e) {
                            clients.remove(client);
                            client.close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(12345);
        server.startServer();
    }
}