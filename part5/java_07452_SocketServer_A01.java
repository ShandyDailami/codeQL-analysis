import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07452_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create new input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive a message from client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Simulate a security-sensitive operation
            if (message.contains("password")) {
                System.out.println("Access Denied!");
                out.println("Access Denied!");
            } else {
                out.println("Access Granted!");
            }

            // Close the connection
            socket.close();
        }
    }
}