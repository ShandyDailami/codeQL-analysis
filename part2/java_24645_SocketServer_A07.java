import java.io.*;
import java.net.*;
import java.util.*;

public class java_24645_SocketServer_A07 {
    private static final int port = 12345;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Client says: " + message);

                String response = "Hello, Client!";
                dos.writeUTF(response);
                System.out.println("Server says: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}