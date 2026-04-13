import java.io.*;
import java.net.*;
import java.util.*;

public class java_25187_SocketServer_A07 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
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

        public java_25187_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    if (clientMessage.equals("auth")) {
                        writer.writeBytes("OK\n");
                    } else {
                        writer.writeBytes("FAIL\n");
                    }

                    writer.flush();
                }

                clientSocket.close();
                clients.remove(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}