import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08752_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a server socket and listen on port 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        // infinite loop to wait for client connections
        while (true) {
            // accept a client connection
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // handle the client connection in a new thread
            new HandleClientThread(client).start();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket client;

    public java_08752_SocketServer_A01(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            // read the request from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // write the response to the client
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("Hello, client!");

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}