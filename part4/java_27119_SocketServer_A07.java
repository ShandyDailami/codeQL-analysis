import java.io.*;
import java.net.*;
import java.util.*;

public class java_27119_SocketServer_A07 {
    private static int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Perform authentication
            if (authenticate(in, out)) {
                handleRequest(in, out, socket);
            } else {
                System.out.println("Authentication failed, closing connection from " + socket.getRemoteSocketAddress());
                out.close();
                socket.close();
            }
        }
    }

    private static boolean authenticate(DataInputStream in, DataOutputStream out) throws IOException {
        // Here you can implement your authentication logic. For now, we'll just return true.
        return true;
    }

    private static void handleRequest(DataInputStream in, DataOutputStream out, Socket socket) throws IOException {
        // Here you can implement your request handling logic. For now, we'll just echo back the request.
        String request = in.readUTF();
        System.out.println("Received request: " + request);

        out.writeUTF("Server received your message: " + request);
        out.flush();
    }
}