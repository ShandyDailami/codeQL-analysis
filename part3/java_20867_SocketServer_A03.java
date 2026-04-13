import java.net.*;
import java.io.*;

public class java_20867_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                socket = serverSocket.accept();

                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String request = dis.readUTF();
                System.out.println("Received: " + request);

                String response = "Hello client, you connected successfully!";
                dos.writeUTF(response);
                dos.flush();

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}