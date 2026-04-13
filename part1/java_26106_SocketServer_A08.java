import java.io.*;
import java.net.*;

public class java_26106_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try {
            server = new ServerSocket(8080); // listen on port 8080
            System.out.println("Waiting for client connection...");
            client = server.accept(); // accept connection from client

            System.out.println("Connection established from " + client.getRemoteSocketAddress());

            // create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // read message from client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // send back a response
                out.println("Server Response: " + message);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (client != null) client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}