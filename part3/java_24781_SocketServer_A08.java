import java.io.*;
import java.net.*;

public class java_24781_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 8080; // default port
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // simulate integrity failure (e.g., message received is not in the expected format)
                if (message.equals("A08_IntegrityFailure")) {
                    dos.writeUTF("Integrity Failure");
                } else {
                    dos.writeUTF("Success");
                }
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}