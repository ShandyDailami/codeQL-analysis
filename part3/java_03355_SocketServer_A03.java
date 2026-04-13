import java.io.*;
import java.net.*;
import java.util.*;

public class java_03355_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(5000);
            System.out.println("Server started at port 5000");
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());
                clients.add(client);
                new Handle(client).start();
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    private static class Handle extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_03355_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }

        public void run() {
            String clientMessage;
            try {
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    for (Socket client : clients) {
                        out = new PrintWriter(client.getOutputStream(), true);
                        out.println("Server: " + clientMessage);
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
                clients.remove(socket);
            }
        }
    }
}