import java.io.*;
import java.net.*;
import java.util.*;

public class java_19138_SocketServer_A07 {
    private static ArrayList<Socket> clientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345); // Listening port
        System.out.println("Server started on port 12345");

        while (true) {
            Socket clientSocket = server.accept(); // Waiting for client to connect
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            clientList.add(clientSocket);

            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket clientSocket;

        public java_19138_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Simulate a failure in authentication
                    if (clientMessage.equals("authFailed")) {
                        out.println("Authentication failed");
                        out.flush();
                        clientSocket.close();
                        clientList.remove(clientSocket);
                        break;
                    } else {
                        out.println("Successfully authenticated");
                        out.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}