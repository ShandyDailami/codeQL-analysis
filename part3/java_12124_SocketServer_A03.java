import java.net.*;
import java.io.*;

public class java_12124_SocketServer_A03 {
    public static void main(String args[]) {
        int port = 1234;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());

                String clientMessage = inputFromClient.readUTF();
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Hello, Client!";
                outputToClient.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}