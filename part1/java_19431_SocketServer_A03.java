import java.io.*;
import java.net.*;
import java.util.*;

public class java_19431_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at " + new Date());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + new Date());

            clients.add(socket);
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        Thread thread = new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Add security-sensitive operation here.
                    // The operation can be anything related to injection, like Cross-Site Scripting (XSS) or SQL Injection.

                    // For demonstration purposes, just echoing back the request.
                    writer.write("Echo: " + request + "\n".getBytes());
                    writer.flush();
                }

                socket.close();
                clients.remove(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}