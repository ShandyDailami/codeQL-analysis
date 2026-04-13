import java.io.*;
import java.net.*;

public class java_00115_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Hello Client, you connected to my server!";
                out.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}