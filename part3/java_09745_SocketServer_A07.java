import java.io.*;
import java.net.*;

public class java_09745_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Waiting for client...");

            Socket client = server.accept();
            System.out.println("Client connected");

            // Input and Output streams
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Hello, you sent: " + inputLine);
            }

            // Close the connection
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}