import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_29622_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static SecretKey key = new SecretKeySpec("Key-1234567890123456".getBytes(), ALGORITHM);

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readLine();
            System.out.println("Received: " + message);

            if (message.equals("QUIT")) {
                out.writeBytes("OK\n");
                socket.close();
            } else {
                out.writeBytes("FAIL\n");
            }
        }
    }
}