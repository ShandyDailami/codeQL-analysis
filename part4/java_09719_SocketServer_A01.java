import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09719_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // read data from client
        String data = input.readUTF();
        System.out.println("Received: " + data);

        // send data back to client
        String response = "Hello, client!";
        output.writeUTF(response);
        System.out.println("Sent: " + response);

        socket.close();
        serverSocket.close();
    }
}