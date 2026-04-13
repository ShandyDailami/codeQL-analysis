import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_12856_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Socket socket = new Socket("localhost", port);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String message = "Hello, client!";
        writer.println(message);

        String response = reader.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}