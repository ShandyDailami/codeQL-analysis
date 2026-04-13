import java.io.*;
import java.net.*;
import java.util.*;

public class java_21699_SocketServer_A03 {
    private static final String SERVER_MSG = "Hello from Server!";
    private static int port = 1234;
    private static ServerSocket server;
    private static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            socket = server.accept();
            System.out.println("Client connected");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);

                if (clientMessage.equals("quit")) {
                    out.println(SERVER_MSG);
                    break;
                }

                // Simulating an injection attempt
                out.println(injectInput(clientMessage));
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String injectInput(String input) {
        // A simple example of a sanitizing function for a string.
        // This function is just for demonstration purposes and should not be used
        // in a production environment.
        return input + " Injected";
    }
}