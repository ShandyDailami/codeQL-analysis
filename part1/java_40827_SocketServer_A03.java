import java.io.*;
import java.net.*;

public class java_40827_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());
                Thread t = new Thread(new ClientHandler(client));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 8080");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_40827_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                out.println("Echo: " + request);
            }
            client.close();
        } catch (IOException e) {
            System.out.println("Exception caught when trying to read from or write to client");
            e.printStackTrace();
        }
    }
}