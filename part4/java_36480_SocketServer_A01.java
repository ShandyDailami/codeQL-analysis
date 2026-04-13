import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36480_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Here we are breaking the access control by giving access to all clients
                // This is a simple example and it's not recommended to do this in a production environment
                socket.setTcpNoDelay(true);
                socket.setReceiveBufferSize(1000000);
                socket.setSendBufferSize(1000000);

                // Now, you can read data from the socket here and handle it
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}