import java.io.*;
import java.net.*;

public class java_22118_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket client = server.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String input;
            while ((input = in.readLine()) != null) {
                out.println("Echo: " + input);
            }

            client.close();
        }
    }
}