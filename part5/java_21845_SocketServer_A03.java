import java.io.*;
import java.net.*;

public class java_21845_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // This is a security-sensitive operation related to A03_Injection
                // It could be anything like a Cross-Site Scripting (XSS) attack,
                // where an attacker sends a crafted message to the server.
                // This is not an actual injection, it's just a demonstration of a security-related operation.
                message = message.replace("<", "&lt;");
                message = message.replace(">", "&gt;");

                writer.println(message);
            }

            socket.close();
        }
    }
}