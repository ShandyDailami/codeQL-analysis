import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25664_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server is listening on port 8888");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client!";
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}