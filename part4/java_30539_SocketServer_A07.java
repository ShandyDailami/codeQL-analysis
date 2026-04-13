import java.net.*;
import java.io.*;

public class java_30539_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 54321;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);

                // Authenticate client
                String auth = "A07_AuthFailure";
                writer.println(auth);

                if (!auth.equals(reader.readLine())) {
                    System.out.println("Authentication failed");
                    continue;
                }

                // Client authenticated, proceed with communication
                handleRequest(socket);
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e);
        }
    }

    private static void handleRequest(Socket socket) {
        // Server code here
    }
}