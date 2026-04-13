import java.net.*;
import java.io.*;

public class java_08369_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for a client...");

        Socket client = server.accept();
        System.out.println("Client has connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);
            out.println("Message received: " + message);
        }

        server.close();
    }
}