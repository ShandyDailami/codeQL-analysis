import java.io.*;
import java.net.*;

public class java_24354_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String request;
                while ((request = reader.readLine()) != null) {
                    if (request.equals("exit")) {
                        writer.println("Goodbye!");
                        socket.close();
                        System.out.println("Client " + socket.getInetAddress().getHostAddress() + " disconnected");
                        break;
                    }

                    // Check if request contains sensitive information
                    if (request.contains("password")) {
                        writer.println("Access denied!");
                        continue;
                    }

                    writer.println("Hello, " + request + "!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}