import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33785_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication Success";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failure";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Receive message from client
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);
                System.out.println("Received message: " + message);

                // Authenticate client
                if (message.equals("Hello")) {
                    socket.getOutputStream().write(AUTHENTICATION_SUCCESS.getBytes());
                } else {
                    socket.getOutputStream().write(AUTHENTICATION_FAILURE.getBytes());
                }
                socket.getOutputStream().flush();
                System.out.println("Sent authentication message");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}