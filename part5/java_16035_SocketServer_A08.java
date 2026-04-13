import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16035_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Waiting for client on port " + PORT);
            socket = server.accept();
            System.out.println("Connected to client");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                if ("exit".equals(message)) {
                    break;
                }
                writer.println("Server: Hello, client");
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}