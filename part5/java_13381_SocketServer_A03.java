import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13381_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(0);
            System.out.println("Server is listening on port " + serverSocket.getLocalPort());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

                InetAddress ip = socket.getInetAddress();
                System.out.println("Client IP: " + ip.getHostAddress());

                // You can also get the port number
                int port = socket.getPort();
                System.out.println("Client Port: " + port);

                // Sending a response
                String response = "Hello, Client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}