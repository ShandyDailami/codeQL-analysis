import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16753_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // listening on port 1234
        while (true) {
            Socket socket = serverSocket.accept(); // wait for client to connect
            System.out.println("Client connected");
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // read message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // send back to client
            output.writeUTF("Hello, client!");
            output.flush();
            socket.close();
        }
    }
}