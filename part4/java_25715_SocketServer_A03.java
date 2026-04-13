import java.io.*;
import java.net.*;
import java.util.*;

public class java_25715_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(6666);
            System.out.println("Server started!");

            while (true) {
                Socket client = server.accept();
                clients.add(client);

                System.out.println("Client connected!");

                new Thread(new ClientHandler(client)).start();
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
        Socket client;

        public java_25715_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Inject code here
                    // For instance, if message is a command to connect to another server,
                    // we can send a message to the server to which the client is connected.
                    for (Socket sock : clients) {
                        try {
                            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);
                            pw.println("Connected to another server!");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}