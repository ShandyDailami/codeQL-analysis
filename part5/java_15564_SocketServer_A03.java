import java.io.*;
import java.net.*;
import java.util.*;

public class java_15564_SocketServer_A03 {
    private static final String QUIT = "quit";
    private static final String CONNECTED_USERS = "Connected users: ";
    private static HashSet<String> users = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from: " + socket.getRemoteSocketAddress());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input;
            if ((input = in.readLine()) != null) {
                if (input.toLowerCase().equals(QUIT)) {
                    out.println("You are now disconnected from the server");
                    users.remove(socket.getRemoteSocketAddress().toString());
                } else {
                    if (users.contains(input)) {
                        out.println("Username already taken. Please enter a different username.");
                    } else {
                        users.add(input);
                        out.println("Username accepted.");
                    }
                }
            }
            out.close();
            socket.close();
        }
    }
}