import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03660_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // create server socket with default port 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening...");

        // accept client connection
        Socket client = server.accept();

        System.out.println("Client connected");

        // close server socket
        server.close();
    }
}