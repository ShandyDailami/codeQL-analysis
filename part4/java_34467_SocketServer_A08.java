import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_34467_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("Client connected");

                    try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                         PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                        String request;
                        while ((request = in.readLine()) != null) {
                            System.out.println("Received: " + request);
                            out.println("OK");
                        }
                    }

                    System.out.println("Client disconnected");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}