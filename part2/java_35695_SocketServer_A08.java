import java.io.*;
import java.net.*;

public class java_35695_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();

            if (message.equals("A08_IntegrityFailure")) {
                // Forward the message to the client.
                out.writeUTF("OK");
            } else {
                out.writeUTF("UNKNOWN MESSAGE");
            }

            out.close();
            in.close();
            socket.close();
        }
    }
}