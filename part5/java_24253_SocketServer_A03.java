import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24253_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected to client");

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage = inputStream.readUTF();
        System.out.println("Received: " + clientMessage);

        // This is a placeholder for a real injection, we'll add a security-sensitive operation here
        String serverMessage = "Your message: " + clientMessage;
        outputStream.writeUTF(serverMessage);
        System.out.println("Sent: " + serverMessage);

        socket.close();
        serverSocket.close();
    }
}