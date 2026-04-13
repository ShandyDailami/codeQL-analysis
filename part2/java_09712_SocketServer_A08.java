import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_09712_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // create server socket
            java.net.ServerSocket server = new java.net.ServerSocket(8080);
            System.out.println("Waiting for client...");

            while (true) {
                // accept client connection
                Socket client = server.accept();
                System.out.println("Client connected");

                // create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // read from client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // write to client
                out.println("Thank you for connecting");

                // close resources
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}