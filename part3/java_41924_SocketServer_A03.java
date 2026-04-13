import java.io.*;
import java.net.*;

public class java_41924_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        while (true) {
            Socket client = server.accept();
            new Thread(new SocketHandler(client)).start();
        }
    }
}

class SocketHandler implements Runnable {
    Socket client;

    public java_41924_SocketServer_A03(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Hello, client, your message was: " + message);
            }

            client.close();
        } catch (Exception e) {
            System.out.println("Error handling client: " + e);
        }
    }
}