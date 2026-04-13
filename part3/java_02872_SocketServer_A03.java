import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02872_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));

        System.out.println("Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Connected client: " + socket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, client!");

            socket.close();
        }
    }
}