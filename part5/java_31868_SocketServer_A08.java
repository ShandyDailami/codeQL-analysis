import java.io.*;
import java.net.*;

public class java_31868_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String request = in.readUTF();
        System.out.println("Received request: " + request);

        if (request.equalsIgnoreCase("fail")) {
            throw new RuntimeException("Intentional Failure");
        }

        out.writeUTF("Successfully processed the request");
        System.out.println("Successfully sent response");

        socket.close();
        server.close();
    }
}