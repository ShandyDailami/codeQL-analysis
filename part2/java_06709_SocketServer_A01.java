import java.io.*;
import java.net.*;
import java.util.*;

public class java_06709_SocketServer_A01 {
    private static final String PASSWORD = "password";
    private static Set<String> authenticatedClients = Collections.newSet();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            while (true) {
                System.out.println("Waiting for connection...");
                try (Socket client = server.accept()) {
                    System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
                    try (InputStreamReader reader = new InputStreamReader(client.getInputStream());
                         BufferedReader in = new BufferedReader(reader)) {
                        String clientPassword = in.readLine();
                        if (clientPassword.equals(PASSWORD)) {
                            authenticatedClients.add(client.getRemoteSocketAddress().toString());
                            System.out.println("Client authenticated");
                            try (OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
                                 PrintWriter out = new PrintWriter(writer)) {
                                out.println("Welcome!");
                                out.flush();
                            }
                        } else {
                            System.out.println("Invalid password, connection refused");
                            try (OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
                                 PrintWriter out = new PrintWriter(writer)) {
                                out.println("Access denied");
                                out.flush();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}