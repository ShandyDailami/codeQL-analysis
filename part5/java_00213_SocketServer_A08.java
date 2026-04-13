import java.io.*;
import java.net.*;

public class java_00213_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            if (request.equals("A08_IntegrityFailure")) {
                out.writeUTF("IntegrityFailureResp");
            } else {
                out.writeUTF("InvalidRequest");
            }

            out.flush();
            socket.close();
        }
    }
}