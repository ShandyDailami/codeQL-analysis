import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26752_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                byte[] buffer = new byte[1024];
                int length = in.read(buffer);
                if (length == -1) {
                    continue;
                }
                out.write(buffer, 0, length);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}