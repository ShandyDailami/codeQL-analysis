import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01458_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Send integrity check packet
                byte[] integrityCheck = "A08_IntegrityFailure".getBytes();
                socket.getOutputStream().write(integrityCheck);
                socket.getOutputStream().flush();

                // Receive response and verify integrity
                byte[] response = new byte[1024];
                socket.getInputStream().read(response);

                if ("A08_IntegrityFailure".equals(new String(response))) {
                    System.out.println("Integrity check passed, response: " + new String(response));
                } else {
                    System.out.println("Integrity check failed, response: " + new String(response));
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}