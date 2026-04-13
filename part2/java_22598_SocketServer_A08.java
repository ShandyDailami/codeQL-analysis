import java.io.*;
import java.net.*;
import java.util.*;

public class java_22598_SocketServer_A08 {

    private static ArrayList<Socket> clientList = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = server.accept();
                clientList.add(clientSocket);
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_22598_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received message: " + clientMessage);
                    // Security-sensitive operations related to A08_IntegrityFailure
                    if (clientMessage.equals("shutdown")) {
                        writer.println("shutdown acknowledged");
                        break;
                    } else {
                        writer.println("Invalid message: " + clientMessage);
                    }
                }
                clientSocket.close();
                clientList.remove(clientSocket);
                System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}