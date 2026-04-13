import java.io.*;
import java.net.*;
import java.util.*;

public class java_21988_SocketServer_A03 {
    private static List<Socket> clients = new ArrayList<>();
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(3333);
            System.out.println("Server is listening...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("New client connected!");

                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_21988_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);

                    // Perform injection attacks here (not shown in the question)
                    // In real scenarios, you would not directly write to out because
                    // the data is already read from the socket. Instead, you'd use
                    // out.writeUTF(message);

                    for (Socket client : clients) {
                        if (client != clientSocket) {
                            out = new DataOutputStream(client.getOutputStream());
                            out.writeUTF("Server: " + message);
                        }
                    }
                }

                clients.remove(clientSocket);
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}