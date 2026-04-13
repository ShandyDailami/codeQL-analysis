import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11802_SocketServer_A03 {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String data = in.readUTF();
            System.out.println("Received: " + data);

            out.writeUTF("Thank you for connecting to " + clientSocket.getLocalSocketPort() + "!");
            clientSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(8080);
    }
}