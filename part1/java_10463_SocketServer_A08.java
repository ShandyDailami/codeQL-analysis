import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10463_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform integrity check
                if (socket.getInetAddress().equals(socket.getLocalAddress()) == false) {
                    System.out.println("Client's IP address is not the same as local IP address, aborting connection");
                    socket.close();
                    continue;
                }

                // Handle the socket here
                // ...

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}