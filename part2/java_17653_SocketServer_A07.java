import java.io.*;
import java.net.*;
import java.util.*;

public class java_17653_SocketServer_A07 {

    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(HOST, PORT));

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // Here we're assuming the client is providing a username and password.
            // In a real application, you'd probably want to securely handle these,
            // for example by using SSL/TLS and storing them securely.
            String[] credentials = inputLine.split(" ");
            String username = credentials[0];
            String password = credentials[1];

            if ("user".equals(username) && "pass".equals(password)) {
                out.println("Authentication successful");
            } else {
                out.println("Authentication failed");
            }
        }

        socket.close();
    }
}