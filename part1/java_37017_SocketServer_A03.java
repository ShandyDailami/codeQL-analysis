import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37017_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Hello from Server";
    private static final int PORT = 9999;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client accepted");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("Client says: " + message);

            out.println(SERVER_MESSAGE);
        }
    }
}