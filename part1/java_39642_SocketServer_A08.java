import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39642_SocketServer_A08 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Here, we're assuming that the client is a valid person and the server is
            // also a valid person, so we're only checking the integrity of the socket,
            // not the actual content sent by the client.
            if (socket.getInputStream().read() != socket.getOutputStream().write(1)) {
                System.out.println("Integrity failure detected!");
                socket.close();
            }
       
        }
    }
}