import java.io.*;
import java.net.*;

public class java_37031_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        int port = 8080; // default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress());
            out.flush();

            socket.close();
        }
    }
}