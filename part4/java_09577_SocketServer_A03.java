import java.io.*;
import java.net.*;

public class java_09577_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666); // listening port
            System.out.println("Server is listening on port 6666");

            while (true) {
                Socket client = server.accept(); // waiting for a client
                System.out.println("Client accepted from " + client.getRemoteSocketAddress());

                // create new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_09577_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) { // if client sends a message
                System.out.println("Client says: " + clientMessage);

                // simple injection example
                // in this case, the client just echoes back whatever it receives
                String serverMessage = clientMessage;

                out.println(serverMessage); // send server message back to client
            }

            // close the connection
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}