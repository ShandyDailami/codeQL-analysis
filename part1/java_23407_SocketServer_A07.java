import java.io.*;
import java.net.*;

public class java_23407_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8001);
        System.out.println("Server Started at Port: 8001");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new Client Connected: " + socket.getRemoteSocketAddress());

            // Step 2: Create Streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 3: Handle Communication
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                if (request.equals("exit")) {
                    out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                    out.flush();
                    socket.close();
                    System.out.println("Client Disconnected");
                    break;
                } else {
                    out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                    out.flush();
                }
            }
            in.close();
            socket.close();
        }
    }
}