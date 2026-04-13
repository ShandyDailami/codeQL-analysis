import java.io.*;
import java.net.*;

public class java_33764_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("exit")) {
                    out.println("Connection closed by client");
                    break;
                }

                if (message.contains("injection")) {
                    // This is where we perform a security-sensitive operation related to A03_Injection
                    // For example, we print the message to the console
                    System.out.println("Injection attempt detected: " + message);
                    out.println("Injection attempt detected, connection closed");
                    break;
                }

                out.println("Server: " + message);
            }

            socket.close();
        }
    }
}