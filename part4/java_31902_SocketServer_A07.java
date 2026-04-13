import java.io.*;
import java.net.*;
import java.util.*;

public class java_31902_SocketServer_A07 {

    private List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().start();
    }

    public void start() {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9876);
            System.out.println("Server started on port 9876");

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                clients.add(client);
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void handleClient(Socket client) {
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    if (message.equals("exit")) {
                        clients.remove(client);
                        client.close();
                        System.out.println("Client disconnected: " + client.getRemoteSocketAddress());
                        break;
                    }

                    // Simulate authentication failure
                    if (message.equals("authFailure")) {
                        out.writeBytes("A07_AuthFailure\n");
                        out.flush();
                        break;
                    }

                    // Simulate server response
                    out.writeBytes("Server response\n");
                    out.flush();

                    // Simulate network delay
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}