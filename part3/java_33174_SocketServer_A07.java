import java.io.*;
import java.net.*;

public class java_33174_SocketServer_A07 {
    private static final int PORT = 6789;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Simple authentication
                String username = in.readUTF();
                if ("user".equals(username)) {
                    out.writeUTF("AuthSuccess");
                } else {
                    out.writeUTF("AuthFailure");
               
                    out.close();
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}