import java.io.*;
import java.net.*;

public class java_34548_SocketServer_A07 {

    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Perform authentication
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String username = reader.readLine();
            if (!authenticate(username)) {
                sendResponse(socket, "A07_AuthFailure");
            } else {
                sendResponse(socket, "Success");
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username) {
        // Add your authentication logic here
        // For simplicity, we'll just return true if the username is "admin"
        return username.equals("admin");
    }

    private static void sendResponse(Socket socket, String response) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(response);
    }
}