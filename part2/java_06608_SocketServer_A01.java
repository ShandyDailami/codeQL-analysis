import java.io.*;
import java.net.*;

public class java_06608_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_06608_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientRequest = reader.readLine();
            System.out.println("Client Request: " + clientRequest);

            // Check if the client's credentials are correct
            String[] clientCredentials = clientRequest.split(":");
            if ("admin".equals(clientCredentials[0]) && "password".equals(clientCredentials[1])) {
                writer.write("Access granted\n".getBytes());
            } else {
                writer.write("Access denied\n".getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}