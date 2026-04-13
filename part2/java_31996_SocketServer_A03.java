import java.io.*;
import java.net.*;
import java.util.*;

public class java_31996_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());
                clients.add(clientSocket);
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        Thread thread = new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    String response = processMessage(message);
                    writer.write(response.getBytes());
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private static String processMessage(String message) {
        // For security, we are assuming that the message contains a simple "Hello, [name]!" statement.
        // If the message contains a command for injection, we will return a malicious response.
        String name = message.split(" ")[1];
        if (isCommandForInjection(name)) {
            return "You are using a command for injection!";
        }
        return "Hello, " + name + "!";
    }

    private static boolean isCommandForInjection(String name) {
        // This is a simple example of a command for injection.
        // In a real scenario, you would likely use a database or command injection tool to check for this.
        String commands = "insert delete select drop create alter ";
        return name.contains(commands);
    }
}