import java.io.*;
import java.net.*;

public class java_34340_SocketServer_A01 {
    private static int port = 1234; // change this to a different port if needed

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Perform any necessary security-sensitive operations here
            // For example, checking if the request is in a known safe list
            if (isSafeRequest(request)) {
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            socket.close();
        }
    }

    private static boolean isSafeRequest(String request) {
        // This is a very simplistic check for demonstration purposes. In a real application,
        // you would need to use a more sophisticated method for checking the safety of the request.
        return request.equals("safe request");
    }
}