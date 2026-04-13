import java.io.*;
import java.net.*;

public class java_07708_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected to: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String received = in.readUTF();
                String reversed = new StringBuilder(received).reverse().toString();

                out.writeUTF(reversed);
                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        }
    }
}