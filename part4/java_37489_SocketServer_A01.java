import java.io.*;
import java.net.*;
import java.util.*;

public class java_37489_SocketServer_A01 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 4445;
    private static int clientCount = 0;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + (++clientCount) + " connected.");

                handleClient(clientSocket);
            }
        } catch (IOException e) {
            System.err.println("Server encountered an error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        Thread clientHandler = new Thread(new ClientHandler(clientSocket));
        clientHandler.start();
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_37489_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection(clientSocket);
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    processRequest(request);
                }
            } catch (IOException e) {
                closeConnection(clientSocket);
            }
        }

        private void processRequest(String request) {
            // This method should be replaced with your actual request processing code
            // The request is a simple string that contains the client's message
            // The server responds with a string that contains the server's response
            // For example, the server might respond with a message like "Hello, client!"

            String response = "Server received: " + request;
            out.println(response);
        }

        private void closeConnection(Socket socket) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}