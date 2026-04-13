import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_11154_SocketServer_A01 {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                out.println("Echo: " + input);
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to read message: " + e);
        }

        System.out.println("Connection closed.");
    }

}