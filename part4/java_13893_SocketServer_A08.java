import java.io.*;
import java.net.*;
import java.util.*;

public class java_13893_SocketServer_A08 {
    private static int port = 12345;
    private static ServerSocket server;
    private static List<Socket> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected.");

                clients.add(client);

                HandleClient clientHandler = new HandleClient(client);
                Thread t = new Thread(clientHandler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class HandleClient implements Runnable {
    private Socket client;

    public java_13893_SocketServer_A08(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream writer = new DataOutputStream(client.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Add security-sensitive operations here

                // Echo back message
                writer.writeBytes("Echo: " + message + "\n");
                writer.flush();
            }

            client.close();
            clients.remove(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}