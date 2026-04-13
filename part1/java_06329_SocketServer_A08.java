import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06329_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Here we use a very basic form of data encryption.
                // In a real-world application, you would use a stronger encryption mechanism.
                // However, this example is meant to demonstrate the basic concept of a secure socket server.
                socket.setSoTimeout(1000);
                socket.setTcpNoDelay(true);

                // Create a new thread for each connection
                new Thread(() -> {
                    try {
                        // Here we read data from the socket and print it
                        byte[] bytes = new byte[1024];
                        int length;
                        while ((length = socket.getInputStream().read(bytes)) != -1) {
                            System.out.println(new String(bytes, 0, length));
                        }

                        // Close the connection when done
                        socket.close();
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