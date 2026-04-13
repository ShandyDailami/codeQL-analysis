import java.io.*;
import java.net.*;

public class java_36096_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_36096_SocketServer_A01(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);

                // For the sake of security, we'll block all incoming requests if they're not well-formatted
                if (request.matches(".*drop.*")) {
                    out.println("Access Denied");
                    out.flush();
                    client.close();
                } else {
                    out.println("Access Granted");
                    out.flush();
                }
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}