import java.io.*;
import java.net.*;

public class java_41895_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received: " + request);

            if ("A07_AuthFailure".equals(request)) {
                dos.writeUTF("401 Unauthorized");
                dos.flush();
            } else {
                dos.writeUTF("200 OK");
                dos.flush();
            }

            socket.close();
        }
    }
}