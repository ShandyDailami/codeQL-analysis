import java.io.*;
import java.net.*;
import java.util.*;

public class java_11080_SocketServer_A07 {

    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();

    static {
        usernames.add("user1");
        usernames.add("user2");
        passwords.add("password1");
        passwords.add("password2");
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000); // creates a server socket on port 5000
            System.out.println("Server started on port 5000");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept(); // waits for a client to connect

                // Handling client connection
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientMessage, serverMessage;

                // Reading username and password from client
                clientMessage = in.readLine();
                System.out.println("Client: " + clientMessage);

                // Authentication
                int i = usernames.indexOf(clientMessage);
                if (i != -1 && passwords.get(i).equals(in.readLine())) {
                    serverMessage = "Authentication Successful!";
                    out.println(serverMessage);
                } else {
                    serverMessage = "Authentication Failed!";
                    out.println(serverMessage);
                }

                out.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}