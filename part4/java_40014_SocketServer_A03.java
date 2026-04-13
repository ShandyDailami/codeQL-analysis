import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_40014_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // create server socket and wait for client connection
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is waiting for client connection...");

            // accept client connection
            Socket client = server.accept();
            System.out.println("Client connected!");

            // read data from client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // write data to client
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // check if client is trying to execute any harmful code
                if (clientMessage.contains("<script>")) {
                    out.println("Error: Invalid command. Do not execute harmful code.");
                } else {
                    out.println("Server: " + clientMessage);
                }
            }

            // close the connection
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}