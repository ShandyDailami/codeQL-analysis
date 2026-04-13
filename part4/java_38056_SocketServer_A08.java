import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_38056_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Socket socket = new Socket("localhost", port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String message = "Hello from the server!";
        out.println(message);

        String response = in.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}