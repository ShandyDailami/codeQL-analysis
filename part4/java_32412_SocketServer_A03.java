import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32412_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Listening port
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept(); // Accepting new connection
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF(); // Reading client's message
                System.out.println("Received: " + clientMessage);

                String response = "Hello, Client!"; // Generating response
                dataOutputStream.writeUTF(response); // Sending response back

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}