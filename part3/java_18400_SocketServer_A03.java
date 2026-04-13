import java.io.*;
import java.net.*;

public class java_18400_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Sending back a message, not the actual injection point
                out.println("Server: Message received, no injection point found");
            }

            socket.close();
       
        }
    }
}