import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27740_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket to accept incoming connections
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        // Step 2: Accept a connection and get a DataInputStream and DataOutputStream
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Step 3: Send a message to the client
        String messageToClient = "Hello, client!";
        out.writeUTF(messageToClient);

        // Step 4: Receive a message from the client
        String messageFromClient = in.readUTF();
        System.out.println("Message from client: " + messageFromClient);

        // Step 5: Close the connection
        socket.close();
    }
}