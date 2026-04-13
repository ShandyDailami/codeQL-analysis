import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19282_SocketServer_A01 {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("A client connected from " + clientSocket.getRemoteSocketAddress());

            // Handle the client connection here

            // Handle client communication here

            clientSocket.close();
        }
    }
}