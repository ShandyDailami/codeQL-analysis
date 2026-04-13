import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09309_SocketServer_A03 {
    private static final String LOCALHOST = "localhost";
    private static final String PASSWORD = "password";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new java.net.InetSocketAddress(LOCALHOST, PORT));

        System.out.println("Server is listening on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            String clientMessage = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()));
            System.out.println("Received: " + clientMessage);

            if (PASSWORD.equals(clientMessage)) {
                socket.getOutputStream().write("Authentication successful!".getBytes());
            } else {
                socket.getOutputStream().write("Authentication failed!".getBytes());
            }

            socket.getOutputStream().close();
            socket.close();
        }
    }
}