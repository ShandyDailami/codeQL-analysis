import java.io.*;
import java.net.*;
import java.util.*;

public class java_01887_SocketServer_A08 {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static ServerSocket server;
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Simulate a security-sensitive operation
                // We're assuming this is a check to see if the client is a valid user
                if (inputLine.equals("invalid")) {
                    out.println("Invalid client, access denied.");
                    out.close();
                    socket.close();
                    System.out.println("Client access denied");
                    return;
                }

                out.println("Hello, client!");
            }

            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}