import java.io.*;
import java.net.*;

public class java_41564_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);

        while (true) {
            Socket socket = server.accept();

            // Perform authentication
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readLine();
            System.out.println("Received request: " + request);

            if ("auth".equals(request)) {
                out.writeBytes("OK\n");
            } else {
                out.writeBytes("FAIL\n");
            }

            socket.close();
        }
    }
}