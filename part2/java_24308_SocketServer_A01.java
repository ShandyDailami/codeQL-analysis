import java.io.*;
import java.net.*;

public class java_24308_SocketServer_A01 {
    private static final int port = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if (request.equals("broken")) {
                out.writeUTF("Denied access to the data due to security violation");
                out.close();
            } else {
                out.writeUTF("Access granted for " + request);
                out.close();
            }

            socket.close();
        }
    }
}