import java.io.*;
import java.net.*;

public class java_05515_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            if (request.equals("A08_IntegrityFailure")) {
                dos.writeUTF("IntegrityFailureResponse");
            } else {
                dos.writeUTF("UnknownRequest");
            }

            dos.flush();
            socket.close();
        }
    }
}