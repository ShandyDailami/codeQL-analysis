import java.io.*;
import java.net.*;

public class java_01412_SocketServer_A07 {
    private static final String SERVER_LOGIN = "Server";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientLogin = dis.readUTF();
                if (clientLogin.equals(SERVER_LOGIN)) {
                    dos.writeUTF("Auth successful");
                } else {
                    dos.writeUTF("Auth failed");
               
                }
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