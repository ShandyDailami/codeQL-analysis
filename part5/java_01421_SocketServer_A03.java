import java.io.*;
import java.net.*;

public class java_01421_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started.");

        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted new connection from: " + client.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread t = new Thread(new ClientHandler(client));
            t.start();
        }
    }
}

class ClientHandler implements Runnable {
    Socket client;

    public java_01421_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Example of security-sensitive operation: use the input string as part of the response.
                // This operation is not secure because the input is directly used in the message.
                String response = "Hello, " + inputLine + "!";
                out.println(response);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}