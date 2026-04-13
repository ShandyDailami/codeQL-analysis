import java.io.*;
import java.net.*;

public class java_34673_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create new threads for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_34673_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Adding security-sensitive operations here
                // Example: checking if the client message contains the word 'password'
                if (clientMessage.contains("password")) {
                    writer.writeBytes("Access denied\n");
                    writer.flush();
                    System.out.println("Access denied");
                    return;
                }

                // Sending a response back to the client
                writer.writeBytes("Message received\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}