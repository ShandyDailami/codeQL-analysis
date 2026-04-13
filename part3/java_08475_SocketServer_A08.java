import java.net.*;
import java.io.*;
import java.util.*;

public class java_08475_SocketServer_A08 {
    private static List<Socket> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clients.add(clientSocket);
            System.out.println("New client connected");

            Thread clientThread = new Thread(new ClientHandler(clientSocket));
            clientThread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_08475_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Process the received message here

                    // Send response
                    out.println("Hello client");
                    out.flush();
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            clients.remove(clientSocket);
            try {
                clientSocket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                // Ignore close exceptions
            }
        }
    }
}