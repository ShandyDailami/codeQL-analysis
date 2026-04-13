import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04901_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Read request
                String request = dataInputStream.readUTF();
                System.out.println("Received request: " + request);

                // Check for authentication
                if (authenticateClient(request)) {
                    // Authentication successful, send response
                    dataOutputStream.writeUTF("Success");
                } else {
                    // Authentication failed, send response
                    dataOutputStream.writeUTF("Failure");
                }

                dataOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(String request) {
        // Implement your authentication logic here
        // For simplicity, we'll just return true for now
        return true;
    }
}