import java.io.*;
import java.net.*;
import java.util.*;

public class java_13640_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Hello, Client!";
    private static final int PORT = 8080;
    private static ServerSocket serverSocket;
    private static List<Socket> clientSockets;

    public static void main(String[] args) throws IOException {
        serverSetup();
        listenForClients();
    }

    private static void serverSetup() throws IOException {
        serverSocket = new ServerSocket(PORT);
        clientSockets = new ArrayList<>();
        System.out.println("Server is listening on port " + PORT);
    }

    private static void listenForClients() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected.");
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Send a welcome message
        out.println(SERVER_MESSAGE);

        // Handle client request in a new thread
        new HandlerThread(in, out, clientSocket).start();
    }

    private static class HandlerThread extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket clientSocket;

        public java_13640_SocketServer_A03(BufferedReader in, PrintWriter out, Socket clientSocket) {
            this.in = in;
            this.out = out;
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            String inputLine;
            try {
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // Perform security-sensitive operations related to injection
                    // For example, execute SQL injection, cross-site scripting (XSS), etc.
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (clientSocket != null) clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}