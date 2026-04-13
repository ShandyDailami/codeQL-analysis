import java.net.ServerSocket;
import java.net.Socket;

public class java_30793_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Here you can handle the communication with the client, for example:
            // BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // String message;
            // while ((message = in.readLine()) != null) {
            //     out.println("Server received: " + message);
            // }

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}