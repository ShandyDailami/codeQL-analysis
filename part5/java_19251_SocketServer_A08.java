import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19251_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            dos.writeUTF("Server received your message: " + message);
            dos.flush();
            socket.close();
        }
    }
}