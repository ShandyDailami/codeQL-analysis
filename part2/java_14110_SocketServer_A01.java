import java.net.ServerSocket;
import java.net.Socket;

public class java_14110_SocketServer_A01 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here is where you should implement access control.
                // For simplicity, this example doesn't use a username or password,
                // but access control can be added based on the client's IP address.
                String ipAddress = socket.getRemoteSocketAddress().toString();

                if (!isAuthorizedIpAddress(ipAddress)) {
                    System.out.println("Access denied for: " + ipAddress);
                    socket.close();
                    continue;
                }

                // Here you should implement your server's response to the client.
                // This is a simple response for the sake of the example.
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example of access control. In a real-world application, you would use a more complex mechanism.
    private static boolean isAuthorizedIpAddress(String ipAddress) {
        // This is a simple example where we only allow a specific IP address.
        // In a real-world application, you would use a more complex method to check the access control.
        return ipAddress.equals("127.0.0.1");
    }
}