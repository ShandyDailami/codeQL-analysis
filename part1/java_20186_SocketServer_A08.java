import java.io.*;
import java.net.*;

public class java_20186_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port: 6000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Request received: " + request);

                // Simple integrity check. This should be replaced with more secure operation.
                if (!request.contains("A08_IntegrityFailure")) {
                    System.out.println("Integrity failure, ignoring request");
                    out.writeUTF("Ignoring request due to integrity failure");
                    out.flush();
                    continue;
                }

                // For simplicity, just echo the request back to the client
                out.writeUTF("Echo: " + request);
                out.flush();
                System.out.println("Response sent: " + in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}