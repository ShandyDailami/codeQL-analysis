import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37319_SocketServer_A03 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, client, your ID is: " + socket.getPort();
            out.writeUTF(serverMessage);

            socket.close();
        }
    }
}