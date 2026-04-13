import java.net.*;
import java.io.*;

public class java_40555_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 12345; // The port the server will listen on
        ServerSocket server = new ServerSocket(port); // Create a server socket
        System.out.println("Server is listening on port " + port);

        // Listen for connections
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Start a new thread for each client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_40555_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read a line from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message = reader.readLine();

            // Assume the message is a simple username, check the password
            if ("admin".equals(message)) {
                output.write("Accepted\n".getBytes());
            } else {
                output.write("Rejected\n".getBytes());
            }

            // Close the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}