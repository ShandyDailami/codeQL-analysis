import java.io.*;
import java.net.*;
import java.util.*;

public class java_36098_SocketServer_A01 {

    private List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().startServer(5000);
    }

    public void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                clients.add(clientSocket);

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_36098_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            try {
                // Read and write messages to/from client
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Process the message here

                    // Send response to client
                    out.println("Server response to client");
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            clients.remove(clientSocket);
            clientSocket.close();
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Client disconnected");
        }
    }
}