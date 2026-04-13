import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07808_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {

        // Create a server socket
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();
            System.out.println("New client connected");

            // Create a buffered reader for the client input
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            // Create a output stream to send a response back to the client
            OutputStream out = client.getOutputStream();

            // Read a line of input from the client
            String message = in.readLine();

            // Check if the message is a command that could be used for injection
            if (message.contains("/script")) {
                // If so, print a security warning and end the connection
                out.write("Security warning: Potential script injection detected\n".getBytes());
                out.close();
                client.close();
                System.out.println("Connection ended");
                continue;
            }

            // If the message is not a command that could be used for injection,
            // just send a response back to the client
            out.write("Received: " + message + "\n".getBytes());
            out.close();
        }
    }
}