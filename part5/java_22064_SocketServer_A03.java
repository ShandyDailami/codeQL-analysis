import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_22064_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and a PrintWriter for the client
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server received: " + inputLine);
                out.println("Hello, client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}