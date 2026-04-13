import java.io.*;
import java.net.*;

public class java_29450_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Print out client information
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Connected to: " + socket.getRemoteSocketAddress());

            // Create new input and output streams for this connection
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Here we handle the message and send a response
                // In a real-world scenario, this could be a simple 'pong'
                outToClient.writeBytes("pong\n");

                // Print out server information
                out.println("Sent: pong");
            }

            out.close();
            in.close();
            socket.close();
        }
    }
}