import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31071_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Here we're assuming the client sends a message in the format "username:password"
                String[] parts = message.split(":");
                if (parts.length == 2 && parts[0].equals("admin") && parts[1].equals("password")) {
                    out.println("Access granted");
                } else {
                    out.println("Access denied");
                }
            }

            socket.close();
        }
    }
}