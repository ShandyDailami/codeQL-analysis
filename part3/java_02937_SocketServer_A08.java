import java.io.*;
import java.net.*;

public class java_02937_SocketServer_A08 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8000);
        System.out.println("Waiting for a client to connect...");

        Socket client = server.accept();
        System.out.println("Connection established with client");

        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        out.writeUTF("Hello client, thanks for connecting!");

        String message = in.readLine();
        System.out.println("Message received from client: " + message);

        client.close();
        server.close();
    }
}