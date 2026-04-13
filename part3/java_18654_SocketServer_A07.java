import java.io.*;
import java.net.*;

public class java_18654_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080");

        while (true) {

            Socket socket = server.accept();

            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();

            if (message.equals("A07_AuthFailure")) {

                out.writeUTF("Authentication failure. Please try again.");
                out.flush();

            } else {

                out.writeUTF("Unknown request. Please try again.");
                out.flush();
            }

            socket.close();

        }
    }
}