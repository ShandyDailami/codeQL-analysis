import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class java_21274_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 5000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String request = dis.readUTF();
                byte[] buffer = Base64.getDecoder().decode(request);
                String response = "Server: Hello, client, your message was: " + new String(buffer);
                dos.writeUTF(response);
                dos.flush();
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}