import java.io.*;
import java.net.*;

public class java_16976_SocketServer_A08 {
    private static int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                String response = processRequest(request);

                out.writeUTF(response);
                out.flush();
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // Process the request here, this is just a placeholder.
        // Real-world applications would handle requests in a more complex way.
        return "Server processed: " + request;
    }
}