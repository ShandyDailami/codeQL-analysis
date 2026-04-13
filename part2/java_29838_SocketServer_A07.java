import java.io.*;
import java.net.*;
import java.util.*;

public class java_29838_SocketServer_A07 {

    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            clients.add(client);

            new EchoThread(client).start();
        }
    }

    private static class EchoThread extends Thread {

        private Socket client;

        public java_29838_SocketServer_A07(Socket client) {
            this.client = client;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    for (Socket sock : clients) {
                        try (BufferedWriter outToClient = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))) {
                            outToClient.write(message);
                            outToClient.newLine();
                            outToClient.flush();
                        }
                    }
                }
            } catch (IOException e) {
                clients.remove(client);
                System.out.println("Client disconnected");
            }
        }
    }
}