import java.io.*;
import java.net.*;

public class java_08545_SocketServer_A07 {
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            if (request.equals("A07_AuthFailure")) {
                // Authentication failure, respond with a 401 Unauthorized
                out.writeUTF("HTTP/1.1 401 Unauthorized\r\n\r\n");
            } else {
                // Authentication success, respond with a 200 OK
                out.writeUTF("HTTP/1.1 200 OK\r\n\r\n");
           
            }

            out.flush();
            socket.close();
        }
    }
}