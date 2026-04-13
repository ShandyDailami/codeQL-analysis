import java.net.Socket;
import java.net.ServerSocket;

public class java_19469_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Here you can add your code to handle client's request

            socket.close();
        }
    }
}