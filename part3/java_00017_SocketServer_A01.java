import java.io.*;
import java.net.*;
import java.util.*;

public class java_00017_SocketServer_A01 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        while (true) {
            Socket socket = serverSocket.accept();
            clients.add(socket);
            Thread thread = new Thread(new ServerThread(socket));
            thread.start();
        }
    }

    private static class ServerThread implements Runnable {
        private Socket socket;

        public java_00017_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message = reader.readLine();
                System.out.println("Client says: " + message);

                // Simulate a security-sensitive operation, e.g., denial of service
                // Here, we'll just forward the message to all clients
                for (Socket client : clients) {
                    if (client != socket) {
                        BufferedReader clientReader = new BufferedReader(
                                new InputStreamReader(client.getInputStream()));
                        DataOutputStream clientWriter = new DataOutputStream(client.getOutputStream());
                        clientWriter.writeBytes(message);
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}