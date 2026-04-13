import java.net.*;
import java.io.*;

public class java_15605_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());

                String clientMessage = inputStream.readUTF();
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Hello, client, your message is safe!";
                outputStream.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}