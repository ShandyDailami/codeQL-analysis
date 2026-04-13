import java.io.*;
import java.net.*;
import java.util.*;

public class java_21615_SocketServer_A03 {

    private static ArrayList<Socket> clientList;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(12345);
            clientList = new ArrayList<>();
            System.out.println("Server started on port 12345");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientList.add(clientSocket);
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_21615_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can use the message for any security sensitive operations
                    // For example, you can check if the message contains certain keywords, 
                    // if it's a command, etc.

                    // You can then respond back to the client or send an error message
                    out.println("Server response: " + message);
                }

                clientSocket.close();
                clientList.remove(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}