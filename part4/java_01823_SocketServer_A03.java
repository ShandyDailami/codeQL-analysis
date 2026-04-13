import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01823_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a server socket
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            // Step 2: Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Create input and output streams
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Step 4: Communicate with the client
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            // Step 5: Send a response back to the client
            String responseMessage = "Hello, client!";
            dataOutputStream.writeUTF(responseMessage);
            System.out.println("Sent message to client: " + responseMessage);

            // Step 6: Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}