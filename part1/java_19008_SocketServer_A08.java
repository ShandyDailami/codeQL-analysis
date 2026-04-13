import java.io.*;
import java.net.*;

public class java_19008_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String response = "Hello, Client!";
                out.writeUTF(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}