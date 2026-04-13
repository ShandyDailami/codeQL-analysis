import java.io.*;
import java.net.*;

public class java_09178_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream output = new DataOutputStream(client.getOutputStream());

                int length = input.readInt();
                byte[] data = new byte[length];
                input.readFully(data);

                System.out.println("Received data: " + new String(data));

                // Simulate integrity failure
                boolean integrityFailure = false;
                if (integrityFailure) {
                    output.writeInt(-1);
                    output.writeUTF("Integrity failure");
                } else {
                    output.writeInt(data.length);
                    output.writeBytes(data);
                }

                output.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}