import java.io.*;
import java.net.*;

public class java_34627_SocketServer_A03 {
    private static final int PORT = 8080;
    private static Socket socket;
    private static ServerSocket server;

    public static void main(String[] args) throws Exception {
        startServer();
        while (true) {
            try {
                socket = server.accept();
                System.out.println("Client connected!");
                handleRequest(socket);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startServer() throws Exception {
        server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);
    }

    private static void handleRequest(Socket socket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String request = in.readLine();
        System.out.println("Received: " + request);

        String response = processRequest(request);
        out.write(response.getBytes());
    }

    private static String processRequest(String request) {
        // TODO: Implement your security-sensitive operations here
        // For example, you can use a database to store and retrieve user credentials,
        // and compare them to the incoming request.
        return "Processed request: " + request;
    }
}