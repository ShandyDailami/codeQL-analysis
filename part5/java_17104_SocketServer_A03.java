import java.io.*;
import java.net.*;

public class java_17104_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Client says: " + request);

                if ("exit".equals(request)) {
                    socket.close();
                    continue;
                }

                String response = "Hello, you wrote: " + request;
                out.writeUTF(response);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}