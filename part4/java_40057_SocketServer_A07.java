import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_40057_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String input;
        while ((input = reader.readLine()) != null) {
            System.out.println("Received: " + input);
            if (input.equals("exit")) {
                break;
            }
        }

        socket.close();
    }
}