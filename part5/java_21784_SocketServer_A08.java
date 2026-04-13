import java.io.*;
import java.net.*;

public class java_21784_SocketServer_A08 {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for connections on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if ("A08_IntegrityFailure".equals(message)) {
                out.writeUTF("IntegrityFailure");
            } else {
                out.writeUTF("OtherMessage");
            }

            out.close();
            socket.close();
        }
    }
}