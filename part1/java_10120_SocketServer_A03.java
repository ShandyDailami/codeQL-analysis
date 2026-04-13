import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10120_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;

        try {
            // Create server socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Accept connection from client
            socket = serverSocket.accept();
            System.out.println("Connection from " + socket.getInetAddress().getHostAddress());

            // Handle communication with client
            Handler handler = new Handler(socket);
            handler.start();

        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            // Close connection
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}