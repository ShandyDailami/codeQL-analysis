import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05298_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // creates a server socket on port 8080

        System.out.println("Waiting for a client to connect...");

        // accept a client
        Socket socket = serverSocket.accept();

        System.out.println("Client connected!");

        // send a response
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("Hello Client!");

        System.out.println("Sent response to client");

        // close the connection
        socket.close();
        serverSocket.close();
    }
}