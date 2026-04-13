import java.net.Socket;
import java.net.ServerSocket;

public class java_22665_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);

        while(true) {
            Socket socket = serverSocket.accept();

            // Handle the client connection here
            // This is a simplistic example and does not implement security measures.
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            socket.close();
        }
    }
}