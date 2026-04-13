import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01445_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a ServerSocket to accept incoming connections.
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            // Accept a client connection.
            Socket client = server.accept();
            System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected");

            // Handle the connection in a new thread.
            new Thread(new ClientHandler(client)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_01445_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Handle the client connection.
        try {
            // Get input and output streams.
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            // Read a line of input.
            byte[] buffer = new byte[1024];
            int length = input.read(buffer);
            String message = new String(buffer, 0, length);
            System.out.println("Received: " + message);

            // Send a response.
            output.write("Hello, client!".getBytes());

            // Close the connection.
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}