import java.io.*;
import java.net.*;

public class java_27326_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Here, we're assuming a very basic type of authentication. In a real application,
            // you'd likely have more complex logic here.
            if (request.equals("AUTH_REQUEST")) {
                dos.writeUTF("AUTHORIZED");
            } else {
                dos.writeUTF("UNAUTHORIZED");
            }

            dos.flush();
            socket.close();
        }
    }
}