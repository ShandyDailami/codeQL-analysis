import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21002_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started at port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Create a new thread for this connection
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("IOException caught when trying to listen on port 1234. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception caught when trying to listen on port 1234. " + e.getMessage());
        }
    }
}