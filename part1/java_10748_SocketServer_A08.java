import java.io.*;
import java.net.*;

public class java_10748_SocketServer_A08 {

    private static int port = 1234;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("Connection established with: " + socket.getRemoteSocketAddress());

                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                String clientMessage = dis.readUTF();
                System.out.println("Client message: " + clientMessage);

                dos.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try { server.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }
}