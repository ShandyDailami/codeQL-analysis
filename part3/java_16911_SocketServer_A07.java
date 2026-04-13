import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16911_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Simulate A07_AuthFailure by rejecting all authentication attempts
            socket.setSoTimeout(10000);
            try {
                socket.getInputStream().read();
            } catch (IOException e) {
                System.out.println("Client " + socket.getRemoteSocketAddress() + " rejected the authentication attempt.");
           
                // Write a response back to the client
                socket.getOutputStream().write("HTTP/1.1 401 Unauthorized\r\n".getBytes());
                socket.getOutputStream().write("Content-Type: Text/Plain; charset=utf-8\r\n".getBytes());
                socket.getOutputStream().write("\r\n".getBytes());
                socket.getOutputStream().write("You do not have permission to view this page.".getBytes());
                socket.getOutputStream().flush();
            } finally {
                socket.close();
            }
        }
    }
}