import java.io.*;
import java.net.*;

public class java_28344_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Hello, client!";
    private static final int PORT = 8080;
    private static final String LOCALHOST = "127.0.0.1";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(PORT, 1, InetAddress.getByName(LOCALHOST));
            System.out.println("Server started on port 8080");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                out.write(SERVER_MESSAGE + "\n");
                out.flush();

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}