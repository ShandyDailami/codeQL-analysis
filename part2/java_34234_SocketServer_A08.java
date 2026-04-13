import java.io.*;
import java.net.*;

public class java_34234_SocketServer_A08 {

    private static final String HOST = "localhost";
    private static final int PORT = 6789;
    private static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (running) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while (((message = in.readLine()) != null)) {
                System.out.println("Received: " + message);
                if (message.equals("close")) {
                    out.writeBytes("Connection closed by client\n\r");
                    running = false;
                    break;
                } else {
                    out.writeBytes("Hello, client\n\r");
                }
                out.flush();
            }
            socket.close();
        }

        serverSocket.close();
    }
}