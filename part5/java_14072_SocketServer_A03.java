import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14072_SocketServer_A03 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket socket = server.accept();
                String remoteHost = socket.getRemoteSocketAddress().toString();

                // check if the client is authorized
                if (!isAuthorized(remoteHost)) {
                    System.out.println("Unauthorized connection from " + remoteHost);
                    continue;
                }

                System.out.println("Connection from " + remoteHost + " accepted.");
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("Hello, Client!\n".getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }

    private static boolean isAuthorized(String remoteHost) {
        // For simplicity, we only allow access from localhost
        return remoteHost.equals("localhost:54697");
    }
}