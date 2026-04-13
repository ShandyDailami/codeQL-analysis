import java.io.*;
import java.net.*;

public class java_03738_SocketServer_A01 {
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();

            // Writes a message to the socket
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello Client, You are connected to port " + socket.getPort());

            // Closes the socket
            socket.close();
        }
    }
}