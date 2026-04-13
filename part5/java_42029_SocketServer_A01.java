import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42029_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Message received: " + message);

                output.writeUTF("Server received your message: " + message);
                output.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}