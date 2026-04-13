import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_41586_SocketServer_A03 {
    private static final String PASSWORD = "pass";
    private static final String USERNAME = "user";
    private static final String PROTOCOL = "SSLv3";

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        try {
            socket = (ServerSocket) SSLServerSocketFactory.createServerSocket(4445, 10000, false, null);

            while (true) {
                SSLSocket client = (SSLSocket) socket.accept();
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                byte[] bytes = new byte[1024];
                int length = input.read(bytes);
                String str = new String(bytes, 0, length);
                if (str.equals(USERNAME + ":" + PASSWORD)) {
                    output.write("OK\n".getBytes());
                    output.flush();
                } else {
                    output.write("FAIL\n".getBytes());
                    output.flush();
                }

                client.close();
            }
        } finally {
            socket.close();
        }
    }
}