import java.io.*;
import java.net.*;

public class java_33387_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        int port = 4445; // listen on port 4445

        ServerSocket server = new ServerSocket(port);

        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read the request
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // check for integrity failure
            if (request.contains("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected. Sending response...");
                out.writeUTF("Integrity failure detected. Please check your request.");
            } else {
                System.out.println("No integrity failures detected. Sending response...");
                out.writeUTF("No integrity failures detected. Your request has been processed successfully.");
            }

            out.flush();
            socket.close();
        }
    }
}