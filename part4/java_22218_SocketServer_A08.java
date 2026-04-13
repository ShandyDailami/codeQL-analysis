import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_22218_SocketServer_A08 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/NoPadding";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        SSLServerSocket sslServer = (SSLServerSocket) server;
        sslServer.setNeedClientAuth(true);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());

        SSLServerSocket socket = (SSLServerSocket) sslServer;
        socket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyStore, null, new java.security.cert.Certificate[]{});

        while (true) {
            Socket connection = socket.accept();
            SSLSocket sslConnection = (SSLSocket) connection.createChannel(socket.getChannel());
            sslConnection.startHandshake();

            SSLSession sslSession = sslConnection.getSession();
            SSLSessionParameters sslSessionParameters = sslSession.getSessionParameters();

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            Key key = sslSessionParameters.getKey();

            cipher.init(Cipher.DECRYPT_MODE, key);

            DataInputStream dis = new DataInputStream(sslConnection.getInputStream());
            DataOutputStream dos = new DataOutputStream(sslConnection.getOutputStream());

            byte[] bytes = new byte[1024];
            int length = dis.read(bytes);
            byte[] decryptedData = cipher.update(bytes, 0, length);

            dos.write(decryptedData);
            dos.flush();
       
            sslConnection.close();
        }
    }
}