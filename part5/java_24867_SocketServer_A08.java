import java.net.ServerSocket;
import java.net.Socket;

public class java_24867_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Here you can add code to securely handle the client, for example:
                // - Reading and sending encrypted data
                // - Checking for integrity failures
                // - Authenticating clients

                // However, as per your request, we will provide a simple code below
                // This just echoes back any received message

                byte[] bytes = new byte[1024];
                int length = socket.getInputStream().read(bytes);
                socket.getOutputStream().write(bytes, 0, length);

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}