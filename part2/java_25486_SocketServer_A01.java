import java.io.*;
import java.net.*;

public class java_25486_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Perform authentication here. For example, we'll just check if the client's name is "admin"
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientName = reader.readLine();
            if (!clientName.equals("admin")) {
                throw new SecurityException("Unauthorized client!");
            }

            // Send a welcome message to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Welcome, " + clientName + "!");
        }
    }
}