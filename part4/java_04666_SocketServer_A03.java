import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04666_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_04666_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            String serverMessage = "Hello, Client!";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Sent message to client: " + serverMessage);

            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(1234);
        server.startServer();
    }
}