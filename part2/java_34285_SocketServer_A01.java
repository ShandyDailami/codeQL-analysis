import java.io.*;
import java.net.*;
import java.util.*;

public class java_34285_SocketServer_A01 {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected...");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private DataOutputStream writer;

        public java_34285_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("IOException: " + ex);
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = reader.readLine();
                    System.out.println("Received: " + message);

                    for (ClientHandler client : clients) {
                        client.writer.writeBytes(message + "\n");
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException: " + ex);
           
                clients.remove(this);
                socket.close();
            }
        }
    }
}