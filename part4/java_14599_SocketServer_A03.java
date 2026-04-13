import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14599_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4445);
        System.out.println("Server is listening on port 4445");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            outputStream.writeUTF("Message received");
            outputStream.flush();

            socket.close();
        }
    }
}