import java.io.*;
import java.net.*;

public class java_12250_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 8000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for handling each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_12250_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from the client
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Perform authentication
                if (authenticateUser(clientMessage)) {
                    // If authentication successful, send a response
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Authentication successful");
                } else {
                    // If authentication failed, send an auth failure response
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Authentication failed");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticateUser(String user) {
        // Implementation of user authentication goes here
        // For simplicity, we'll return true if the user is "admin" and false otherwise
        return user.equals("admin");
    }
}