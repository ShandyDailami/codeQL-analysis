import java.io.*;
import java.net.*;

public class java_07161_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String clientInput;

            if ((clientInput = in.readLine()) != null) {
                System.out.println("Received: " + clientInput);
                out.println("Hello, client, your data was received.");
            }

            client.close();
        }
    }
}