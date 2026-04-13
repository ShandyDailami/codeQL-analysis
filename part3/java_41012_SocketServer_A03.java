import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class java_41012_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444); // Port number to listen on
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (true) {
            try {
                SSLSocket socket = serverSocket.accept(); // Wait for a client connection
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String greeting = "Hello " + socket.getRemoteSocketAddress() + "，欢迎访问安全通信服务器！";
                out.println(greeting);

                String user = "admin"; // Hardcoded user for now. In real world, it should be retrieved from a database.
                String password = "password"; // Hardcoded password for now. In real world, it should be retrieved from a database.

                if (authenticate(socket, user, password)) {
                    out.println("身份验证成功，欢迎回来！");
                } else {
                    out.println("身份验证失败，拒绝访问！");
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭连接 " + socket.getRemoteSocketAddress());
            }
        }
    }

    private static boolean authenticate(Socket socket, String user, String password) {
        // Assume we are using Base64 encoding for user and password.
        // This is not the best way to handle passwords in real world, but it's a starting point.
        String encodedUser = Base64.getEncoder().encodeToString(user.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        String encodedProvidedUser = Base64.getEncoder().encodeToString(socket.getRemoteSocketAddress().getAddress().getAddress());
        String encodedProvidedPassword = Base64.getEncoder().encodeToString(socket.getInputStream().readAllBytes());

        return encodedUser.equals(encodedProvidedUser) && encodedPassword.equals(encodedProvidedPassword);
    }
}