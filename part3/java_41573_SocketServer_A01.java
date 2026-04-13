import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.*;

public class java_41573_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket server = null;
        Socket socket = null;
        SSLServerSocket sslServer = null;
        SSLSocket sslSocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            server = new ServerSocket(PORT);
            server.setReuseAddress(true);

            sslServer = (SSLServerSocket) server.accept();
            sslServer.setNeedClientAuth(true);

            sslSocket = (SSLSocket) sslServer.accept();

            in = new DataInputStream(sslSocket.getInputStream());
            out = new DataOutputStream(sslSocket.getOutputStream());

            String message = in.readUTF();
            out.writeUTF("Welcome to secure socket server. Your message was: " + message);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (sslSocket != null) {
                sslSocket.close();
            }
            if (sslServer != null) {
                sslServer.close();
            }
            if (server != null) {
                server.close();
            }
        }
    }
}