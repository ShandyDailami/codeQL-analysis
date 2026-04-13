import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09452_SocketServer_A01 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new java.net.InetSocketAddress(LOCALHOST, PORT));

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected from " + socket.getRemoteSocketAddress());

            // Check if the client's IP address is allowed to connect
            String clientIP = socket.getRemoteSocketAddress().toString();
            if (!isAllowedIP(clientIP)) {
                System.out.println("Client IP " + clientIP + " is not allowed to connect.");
                socket.close();
                continue;
            }

            // Handle the client's request here
            // For example, we can just echo back the request
            byte[] bytes = new byte[1000];
            int bytesRead = socket.getInputStream().read(bytes);
            if (bytesRead < 0) {
                System.out.println("Client disconnected.");
                socket.close();
            } else {
                String response = new String(bytes, 0, bytesRead);
                System.out.println("Received: " + response);
                socket.getOutputStream().write(response.getBytes());
            }
        }
    }

    private static boolean isAllowedIP(String ip) {
        // This is a simple check for demonstration purposes. In a real-world scenario,
        // you would want to check against a list of allowed IPs, not just the local host.
        return !ip.equals("localhost") && !ip.equals("127.0.0.1");
    }
}