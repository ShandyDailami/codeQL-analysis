import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_18508_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        Socket socket = new Socket("localhost", port);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            // Bypass the 'A01_BrokenAccessControl'
            String response = message.replaceAll("[^a-zA-Z0-9]", "");
            out.println(response);
        }

        socket.close();
    }
}