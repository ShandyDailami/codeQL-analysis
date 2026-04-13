import java.io.*;
import java.net.*;
import java.util.*;

public class java_39245_SocketServer_A01 {
    private static ArrayList<Socket> clients = new ArrayList<Socket>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server started at " + new Date());

            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_39245_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    if (message.equalsIgnoreCase("bye")) {
                        clients.remove(socket);
                        System.out.println("Client disconnected from " + socket.getRemoteSocketAddress());
                        break;
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}