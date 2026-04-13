import java.io.*;
import java.net.*;

public class java_12493_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        System.out.println("Server is listening on port 6789");

        while (true) {
            Socket client = server.accept();
            System.out.println("Connection established with " + client.getRemoteSocketAddress());

            // Create a new thread for each client connection
            Thread t = new Thread(new ClientHandler(client));
            t.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_12493_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                // Injection attempt: replace 'injection' with a command to send back a malicious message
                if (message.equals("injection")) {
                    out.println("Malicious server message!");
                    continue;
                }

                // Otherwise, simply echo the message back to the client
                out.println("Server: " + message);
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}