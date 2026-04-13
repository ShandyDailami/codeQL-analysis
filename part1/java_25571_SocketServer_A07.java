import java.io.*;
import java.net.*;
import java.util.*;

public class java_25571_SocketServer_A07 {
    static final String SERVER_HOST = "localhost";
    static final int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(SERVER_HOST, SERVER_PORT));

        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String userInput;
            if ((userInput = in.readLine()) != null) {
                if ("username password".equals(userInput)) {
                    out.println("Welcome back!");
                } else {
                    out.println("Sorry, wrong password.");
                }
            }

            socket.close();
        }
    }
}