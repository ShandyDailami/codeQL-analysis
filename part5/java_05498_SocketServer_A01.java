import java.io.*;
import java.net.*;

public class java_05498_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Server is listening on port 9000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                outputStream.writeUTF("Welcome to the server!");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println("Client says: " + inputStream.readUTF());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
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