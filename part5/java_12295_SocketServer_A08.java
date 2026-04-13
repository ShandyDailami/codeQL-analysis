import java.io.*;
import java.net.*;

public class java_12295_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            System.out.println("Waiting for a client...");

            Socket socket = serverSocket.accept();
            System.out.println("A client has connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("A08_IntegrityFailure")) {
                out.writeUTF("IntegrityFailure");
            } else {
                out.writeUTF("Unknown message");
            }

            out.flush();
            socket.close();
        }
    }
}