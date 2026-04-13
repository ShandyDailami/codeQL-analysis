import java.io.*;
import java.net.*;

public class java_09687_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // create server socket
            ServerSocket server = new ServerSocket(2222);
            System.out.println("Server started at port 2222");

            while (true) {
                // create client socket
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // create input stream from client
                DataInputStream dis = new DataInputStream(client.getInputStream());
                String message = dis.readUTF();

                // process the message
                // in a real-world scenario, you would want to check for injection attacks here

                System.out.println("Received: " + message);

                // send response
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF("Thank you for connecting to " + client.getLocalSocketAddress() + "\n");

                dos.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}