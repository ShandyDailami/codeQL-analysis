import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_12216_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Socket socket = new Socket("localhost", port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Client: " + input);
            out.println("Hello, Client!");
        }

        socket.close();
    }
}