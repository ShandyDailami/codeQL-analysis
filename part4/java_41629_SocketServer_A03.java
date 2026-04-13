import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41629_SocketServer_A03 {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening...");

            socket = serverSocket.accept();
            System.out.println("Client connected...");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, " + clientMessage;
            out.writeUTF(serverMessage);
            out.flush();

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}