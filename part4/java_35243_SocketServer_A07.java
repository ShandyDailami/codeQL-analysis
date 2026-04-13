import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35243_SocketServer_A07 {
    public static void main(String[] args) {
        boolean enableSecurity = true; // Change this to false for testing

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080. Waiting for connections...");

            while (true) {
                Socket socket = server.accept();

                if (enableSecurity) {
                    if ("localhost".equals(socket.getLocalAddress().getHostName())) {
                        System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());
                    } else {
                        System.out.println("Connection dropped from " + socket.getRemoteSocketAddress());
                        socket.close();
                    }
                } else {
                    System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}