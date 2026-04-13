import java.io.*;
import java.net.*;

public class java_39153_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client on port " + 6000);

        Socket socket = server.accept();
        System.out.println("Connection established with " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String request = in.readUTF();
        System.out.println("Received: " + request);

        // Simulate a security sensitive operation
        if (request.equals("auth")) {
            out.writeUTF("success");
        } else {
            out.writeUTF("failure");
        }

        out.close();
        socket.close();
        server.close();
    }
}