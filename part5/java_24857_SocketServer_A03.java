import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_24857_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        int port = 1234; // Change to desired port
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client accepted from " + client.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Example of Injection Attack
                // The following line could be an injection point if the received message
                // contained a command that could cause a buffer overflow or other similar
                // security risk.
                if (message.contains("inject")) {
                    System.out.println("Injection attempt detected");
                    out.println("Injection attempt detected");
                } else {
                    out.println("Server: " + message);
                }
            }
        }
    }
}