import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34016_SocketServer_A07 {

    private static final String SERVER_IP = "127.0.0.1"; // IP address of the server
    private static final int SERVER_PORT = 8080; // Port number to use
    private static final String ALLOWED_CLIENT_IP = "127.0.0.1"; // IP address of the client that is allowed to connect

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            // Create server socket
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on IP: " + SERVER_IP + " and port: " + SERVER_PORT);

            // Accept a new connection from the client
            socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected.");

            // Create input and output streams
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Check if the client's IP address is allowed
            if (!socket.getInetAddress().getHostAddress().equals(ALLOWED_CLIENT_IP)) {
                System.out.println("Connection from " + socket.getInetAddress().getHostAddress() + " is not allowed.");
                dataOutputStream.writeUTF("Connection from " + socket.getInetAddress().getHostAddress() + " is not allowed.");
                socket.close();
                return;
            }

            // Communicate with the client
            String message = dataInputStream.readUTF();
            System.out.println("Received message from client: " + message);
            dataOutputStream.writeUTF("Server says: Hello " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close streams and server socket
            try {
                if (dataInputStream != null)
                    dataInputStream.close();
                if (dataOutputStream != null)
                    dataOutputStream.close();
                if (socket != null)
                    socket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}