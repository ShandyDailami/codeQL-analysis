import java.io.*;
import java.net.*;

public class java_29998_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6789);
            System.out.println("Server is running... ");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected... ");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMsg = dis.readUTF();
                System.out.println("Client says: " + clientMsg);

                String serverMsg = "Hello Client, you connected to our server!";
                dos.writeUTF(serverMsg);
                System.out.println("Server says: " + serverMsg);

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