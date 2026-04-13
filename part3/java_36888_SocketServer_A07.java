import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36888_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Authenticate the client
            if (authenticateClient(dataInputStream, dataOutputStream)) {
                System.out.println("Client authenticated successfully");

                // Start handling the client
                handleClient(dataInputStream, dataOutputStream);
            } else {
                System.out.println("Client authentication failed");
                dataOutputStream.close();
                socket.close();
            }
        }
    }

    private static boolean authenticateClient(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        // Assume the client is authenticated by sending a 'hello' message
        String clientMessage = dataInputStream.readUTF();
        if ("hello".equals(clientMessage)) {
            // Client is authenticated, send 'world' message back
            dataOutputStream.writeUTF("world");
            dataOutputStream.flush();
            return true;
        } else {
            return false;
        }
    }

    private static void handleClient(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException {
        // Assume client wants to send a message
        String message = dataInputStream.readUTF();
        System.out.println("Client says: " + message);

        // Assume client wants to send a response back
        String response = "Hello, " + message;
        dataOutputStream.writeUTF(response);
        dataOutputStream.flush();
    }
}