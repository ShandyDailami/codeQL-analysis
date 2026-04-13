import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_22746_SocketServer_A07 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "_OFB";
    private static final byte[] KEY = "0123456789ABCDEF".getBytes();

    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket(5000);
        Socket client = socket.accept();

        SSLServerSocket sslServerSocket = (SSLServerSocket) socket;
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        Key key = new SecretKeySpec(KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);

        InputStream in = sslSocket.getInputStream();
        DataInputStream din = new DataInputStream(in);
        OutputStream out = sslSocket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);

        byte[] buffer = new byte[1024];
        int bytesRead = din.read(buffer);
        String message = new String(cipher.update(buffer, 0, bytesRead), "UTF-8");

        dout.write(message.getBytes());
        dout.flush();

        sslSocket.close();
        client.close();
    }
}