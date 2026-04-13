import java.io.*;
import java.net.*;

public class java_28696_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6789);
            System.out.println("Server is listening on port 6789");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream output = new DataOutputStream(client.getOutputStream());

                // Echo back the request
                String request = input.readUTF();
                System.out.println("Received: " + request);
                output.writeUTF("Echo: " + request);
                output.flush();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}