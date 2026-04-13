import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13250_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Auth successful";
    private static final String AUTH_FAILURE = "Auth failure";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is waiting for client connections on port 8080");
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClientThread extends Thread {
        private final Socket socket;

        HandleClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                String message = socket.getInputStream().readUTF();
                if (handleAuthentication(message)) {
                    socket.getOutputStream().writeUTF(AUTH_SUCCESS);
                } else {
                    socket.getOutputStream().writeUTF(AUTH_FAILURE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean handleAuthentication(String message) {
            // This is a simple example where we assume the password is "password". 
            // In a real application, you would typically use a more secure way of handling authentication.
            return message.equals("password");
        }
    }
}