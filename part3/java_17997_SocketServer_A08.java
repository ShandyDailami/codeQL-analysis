import java.io.*;
import java.net.*;

public class java_17997_SocketServer_A08 {
    private static final int PORT = 4446;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Client says: " + message);

            message = message.replace("A08_IntegrityFailure", "Security Violation");
            dos.writeUTF(message);
            dos.flush();

            socket.close();
        }
    }
}