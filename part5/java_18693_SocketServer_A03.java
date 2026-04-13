import java.io.*;
import java.net.*;

public class java_18693_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started on port 8080. Waiting for client...");

        Socket socket = serverSocket.accept();

        System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        // Read the client's message
        String clientMessage = dataInputStream.readUTF();
        System.out.println("Client says: " + clientMessage);

        // Echo the client's message back to them
        String serverMessage = "Server says: " + clientMessage;
        dataOutputStream.writeUTF(serverMessage);
        dataOutputStream.flush();

        // Close the connection
        socket.close();
    }
}