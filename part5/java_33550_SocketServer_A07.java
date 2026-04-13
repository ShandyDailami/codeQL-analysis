import java.io.*;
import java.net.*;
import java.util.*;

public class java_33550_SocketServer_A07 {

    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            if (handleRequest(request)) {
                dos.writeUTF("Authentication successful");
            } else {
                dos.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean handleRequest(String request) {
        // You should use a more secure way to parse the request and compare it with a hardcoded value.
        return request.equals("A07_AuthFailure");
    }

}