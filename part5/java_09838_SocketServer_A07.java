import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09838_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("Server is listening on port 6666");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = input.readUTF()) != null) {
                System.out.println("Client says: " + clientMessage);
                output.writeUTF("Server says: " + clientMessage);
            }

            output.close();
            input.close();
            socket.close();
        }
    }
}