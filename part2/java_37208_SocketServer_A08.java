import java.io.*;
import java.net.*;

public class java_37208_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000, 0, InetAddress.getByName("localhost"));
        System.out.println("Waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(
                               new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        String clientInput;
        while ((clientInput = in.readLine()) != null) {
            System.out.println("Received: " + clientInput);
            if (clientInput.equals("close")) {
                out.println("Server closing");
                out.close();
                in.close();
                client.close();
                server.close();
                System.out.println("Connection closed");
                break;
            } else {
                out.println("Server response: " + clientInput);
            }
        }
    }
}