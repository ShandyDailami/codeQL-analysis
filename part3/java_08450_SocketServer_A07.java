import java.io.*;
import java.net.*;
import java.util.*;

public class java_08450_SocketServer_A07 {
    private static ArrayList<Socket> clientList = new ArrayList<>();
    private static ServerSocket serverSocket;
    private static int port;

    public static void main(String[] args) {
        port = 9876; // Change this port to a port you wish to use

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started on Port: " + port);

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("New Client Connected: " + client.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Authentication process
                boolean authenticated = authenticate(in, out);

                if (authenticated) {
                    clientList.add(client);
                    broadcastMessage("New Client Connected: " + client.getRemoteSocketAddress(), out);
                } else {
                    client.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(BufferedReader in, DataOutputStream out) throws IOException {
        // Read username from client
        String username = in.readLine();
        System.out.println("Received Username: " + username);

        // Assume that the username is a simple password (for now)
        if (username.equals("admin")) {
            out.write("Authentication Successful\n".getBytes());
            out.flush();
            return true;
        } else {
            out.write("Authentication Failed\n".getBytes());
            out.flush();
            return false;
        }
    }

    private static void broadcastMessage(String message, DataOutputStream out) throws IOException {
        for (Socket client : clientList) {
            out.write(message.getBytes());
            out.flush();
        }
    }
}