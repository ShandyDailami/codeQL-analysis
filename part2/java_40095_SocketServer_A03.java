import java.net.ServerSocket;
import java.net.Socket;

public class java_40095_SocketServer_A03 {

    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations
                String injectionProof = "C03_Injection: " + socket.getInetAddress().getHostAddress();
                System.out.println("Injection proof: " + injectionProof);

                // Here, the injection proof is just a placeholder for real code.
                // In a real scenario, this injection proof would be used to authenticate the client, handle
                // the request, and then return a response.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}