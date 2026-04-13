import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05955_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Here, we use a simplistic authentication method where we check if the username and password match a pre-defined set.
            // In a real-world scenario, this would be done in a secure and authenticated manner.
            String username = socket.getInputStream().readUTF();
            String password = socket.getOutputStream().readUTF();

            if ("username".equals(username) && "password".equals(password)) {
                socket.getOutputStream().writeBoolean(true);
            } else {
                socket.getOutputStream().writeBoolean(false);
            }

            socket.close();
        }
    }
}