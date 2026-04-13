import java.io.*;
import java.net.*;

public class java_39787_SocketServer_A07 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(LOCALHOST, PORT));

        System.out.println("Server is listening on " + LOCALHOST + " port " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String response = "Hello Client, you are connected to the Socket Server.";
            outputStream.writeUTF(response);

            socket.close();
        }
    }
}