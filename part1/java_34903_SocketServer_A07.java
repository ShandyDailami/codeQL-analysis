import java.io.*;
import java.net.*;

public class java_34903_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Start a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_34903_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error initializing stream readers and writers for client " + socket.getRemoteSocketAddress());
            }
        }

        public void run() {
            try {
                // Read the request from the client
                String request = in.readLine();

                // Perform authentication
                if (authenticate(request)) {
                    // If authentication succeeds, send a response
                    out.println("Authentication successful");
                } else {
                    // If authentication fails, send a failure response
                    out.println("Authentication failed");
                }

                // Close the connection
                out.close();
            } catch (IOException e) {
                System.out.println("Error handling client " + socket.getRemoteSocketAddress());
            }
        }

        private boolean authenticate(String request) {
            // Implement your authentication logic here. For the sake of this example, we'll just return true if the request is "username:password"
            String[] credentials = request.split(":");
            if (credentials.length == 2 && "username".equals(credentials[0]) && "password".equals(credentials[1])) {
                return true;
            } else {
                return false;
            }
        }
    }
}