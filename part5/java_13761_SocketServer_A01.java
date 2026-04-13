import java.io.*;
import java.net.*;

public class java_13761_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while(true) {
                Socket client = server.accept();
                System.out.println("Connected with " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Receive data from client
                String data = in.readUTF();
                System.out.println("Received: " + data);

                // Send data to client
                out.writeUTF("Server: Hello, client, thanks for connecting!");
                out.flush();
           
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}