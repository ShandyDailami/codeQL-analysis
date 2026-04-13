import java.io.*;
import java.net.*;

public class java_13690_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 1234; // the port to listen on

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Use a thread for each client connection
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection " + ex.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_13690_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());

            // Assume that the client sends a string to the server
            String clientMessage = reader.readLine();

            // Inject an SQL query into the clientMessage string using an SQL injection attack
            // Assume that the clientMessage contains a SQL query
            clientMessage = "SELECT * FROM users WHERE username = '" + clientMessage + "'";

            writer.writeBytes("Hello, " + clientMessage + "\n");
            writer.flush();

            clientSocket.close();
        } catch (IOException ex) {
            System.out.println("Error handling client " + ex.getMessage());
        }
    }
}