import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28293_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                // handle client here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}