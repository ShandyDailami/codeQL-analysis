import java.io.*;
import java.net.*;

public class java_02091_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received client message: " + clientMessage);

                // Real-world example of authentication failure here
                if ("bad_password".equals(clientMessage)) {
                    out.writeUTF("Authentication failed");
                    out.close();
                    socket.close();
                } else {
                    out.writeUTF("Authentication successful");
                    out.close();
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}