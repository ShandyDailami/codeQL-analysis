import java.io.*;
import java.net.*;

public class java_38643_SocketServer_A08 {
    private static final int port = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket client = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                    String message = in.readLine();
                    if ("exit".equals(message)) {
                        break;
                    }
                    if ("echo".equals(message)) {
                        out.println("Echo: " + message);
                    } else {
                        out.println("Unknown command: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}