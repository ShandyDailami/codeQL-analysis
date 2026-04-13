import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04679_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                AuthHandler handler = new AuthHandler(socket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class AuthHandler implements Runnable {
    private Socket socket;

    public java_04679_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Add here the authentication process with a secure channel
            // For simplicity, we'll just log the IP address
            System.out.println("Authenticating client " + socket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}