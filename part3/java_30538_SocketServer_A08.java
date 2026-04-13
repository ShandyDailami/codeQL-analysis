import java.io.*;
import java.net.*;

public class java_30538_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readLine();
            System.out.println("Received: " + clientMsg);

            // Verify the integrity of the message by checking the integrity value (integrity check)
            // Here, we will just simulate this check by verifying if the client's message is uppercase
            if (clientMsg.equals(clientMsg.toUpperCase())) {
                out.writeBytes("Integrity Verified\n");
            } else {
                out.writeBytes("Integrity Failure\n");
            }
            out.flush();
        }
    }
}