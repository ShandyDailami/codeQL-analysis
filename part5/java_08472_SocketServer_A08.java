import java.io.*;
import java.net.*;

public class java_08472_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Client says: " + request);

            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Server says: " + response);

            socket.close();
        }
    }
}