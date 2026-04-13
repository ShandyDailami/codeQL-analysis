import java.io.*;
import java.net.*;
import java.util.*;

public class java_34168_SocketServer_A07 {
    private static List<String> authorizedClients = Arrays.asList("John", "Alice", "Bob");
    private static String serverPassword = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234); // port number
            System.out.println("Server started with port number: " + serverSocket.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientName = in.readUTF();

                if (isClientAuthorized(clientName)) {
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("Hello " + clientName);
                } else {
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF("Access denied for " + clientName);
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isClientAuthorized(String clientName) {
        return authorizedClients.contains(clientName) && isClientPasswordCorrect(clientName);
    }

    private static boolean isClientPasswordCorrect(String clientName) {
        // In a real application, you'd want to use a secure way to store and compare passwords,
        // such as a hash and salt. This is just a simple implementation for demonstration purposes.
        return serverPassword.equals(getClientPassword(clientName));
    }

    // Simplified password retrieval method for demonstration purposes. In a real application,
    // you'd want to use a more secure way of retrieving and comparing passwords.
    private static String getClientPassword(String clientName) {
        // In a real application, you'd need to store the passwords and client names in a database.
        // This is just a simple implementation for demonstration purposes.
        if (clientName.equals("John")) {
            return "johnpassword";
        } else if (clientName.equals("Alice")) {
            return "alicepassword";
        } else if (clientName.equals("Bob")) {
            return "bobpassword";
        } else {
            return "";
        }
    }
}