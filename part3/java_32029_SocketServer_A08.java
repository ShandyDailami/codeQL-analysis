import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32029_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            InetAddress ip = socket.getInetAddress();
            System.out.println("Client IP: " + ip);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Client, I am your server!");
        }
    }
}