import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12428_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket client;

    public java_12428_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Echo the message back to the client
                out.println("Echo: " + clientMessage);
            }

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}