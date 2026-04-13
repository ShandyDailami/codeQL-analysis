import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_41245_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        int port = 1234; // listen on port 1234
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle input from client
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);

                // Security sensitive operation: Blocking input
                // This will block the connection until a response is received
                out.println("Received your message: " + input);

                // This is to simulate a delay
                Thread.sleep(1000);
            }

            socket.close();
        }
    }
}