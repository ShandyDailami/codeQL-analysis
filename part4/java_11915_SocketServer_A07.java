import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11915_SocketServer_A07 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on " + SERVER_ADDRESS + " port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection from " + socket.getRemoteSocketAddress());

                // Perform authentication here
                // This is a very basic example and should not be used in a real application
                String username = socket.getInputStream().readUTF();
                if ("admin".equals(username)) {
                    socket.getOutputStream().writeUTF("Welcome admin!");
                    socket.getOutputStream().flush();
                } else {
                    socket.getOutputStream().writeUTF("Access denied!");
                    socket.getOutputStream().flush();
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}