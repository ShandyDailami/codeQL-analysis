import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27474_SocketServer_A01 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A new client connected: " + clientSocket.getRemoteSocketAddress());

                // Handle the client request here
                // For the sake of simplicity, we'll just echo back the message received
                new Thread(() -> {
                    try {
                        byte[] bytes = new byte[clientSocket.getInputStream().read(new byte[1024])];
                        String message = new String(bytes);
                        System.out.println("Received message: " + message);

                        clientSocket.getOutputStream().write(bytes);
                        clientSocket.getOutputStream().flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}