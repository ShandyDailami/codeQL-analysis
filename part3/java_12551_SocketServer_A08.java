import java.io.*;
import java.net.*;

public class java_12551_SocketServer_A08 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 8080;
    private static final String SERVLET_HOME = "http://" + LOCALHOST + ":" + PORT + "/";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(LOCALHOST, PORT));
        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Sending a welcome message
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("Welcome to the server!");

            // Listening for client messages
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
            }

            socket.close();
        }
    }
}