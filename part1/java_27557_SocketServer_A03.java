import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27557_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen for incoming connections on port 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            // Accept a new connection
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // Start a new thread to handle the client
            new Handler(client).start();
        }
    }
}

class Handler extends Thread {
    private Socket client;

    public java_27557_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // Create an input stream and a reader for the client
            InputStream input = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Read a line of data from the client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            OutputStream output = client.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Echo: " + message);

            // Close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}