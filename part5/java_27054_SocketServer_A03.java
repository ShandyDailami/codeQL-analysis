import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_27054_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        Socket socket = new Socket("localhost", port);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Server received: " + input);

            // Simulate injection attempt by user
            // This is a very basic example and should not be used in a real world application
            if (input.contains("inject")) {
                System.out.println("Injection attempt detected, refusing connection");
                socket.close();
                return;
            }

            out.println("Server response: " + input);
        }

        socket.close();
    }
}