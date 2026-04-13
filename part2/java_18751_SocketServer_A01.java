import java.net.Socket;
import java.net.ServerSocket;

public class java_18751_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);

        while (true) {
            Socket socket = server.accept();

            // Here, we assume that the server should only accept connections from localhost
            if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                System.out.println("Connection from " + socket.getRemoteSocketAddress());

                // Here we assume that the client is sending a message and expecting a response
                socket.getOutputStream().write("Hello, Client!".getBytes());
                socket.getOutputStream().flush();

                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                System.out.println("Message from client: " + new String(buffer));
            } else {
                System.out.println("Connection from an unexpected address: " + socket.getRemoteSocketAddress());
           
            }
        }
    }
}