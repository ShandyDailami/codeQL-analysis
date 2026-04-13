import java.io.*;
import java.net.*;
import java.util.*;

public class java_25950_SocketServer_A03 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("New client connected.");

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_25950_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here you can implement security-sensitive operations related to A03_Injection, like checking the content of the message and sanitizing it, or encrypting the message before sending it.

                    // Sending the sanitized or encrypted message back to the client
                    OutputStream output = clientSocket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("Received: " + message);
                    writer.flush();
                }

                clientSocket.close();
                clients.remove(clientSocket);
                System.out.println("Client disconnected.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}