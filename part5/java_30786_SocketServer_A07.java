import java.io.*;
import java.net.*;
import java.util.*;

public class java_30786_SocketServer_A07 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            Socket client = server.accept();
            clients.add(client);
            System.out.println("Client connected");

            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        Socket client;

        public java_30786_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream writer = new DataOutputStream(client.getOutputStream());

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);

                    if (line.equals("A07_AuthFailure")) {
                        writer.writeBytes("A07_AuthFailure: Success\n");
                    } else {
                        writer.writeBytes("Unknown command\n");
                    }

                    writer.flush();
                }

                client.close();
                clients.remove(client);
                System.out.println("Client disconnected");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}