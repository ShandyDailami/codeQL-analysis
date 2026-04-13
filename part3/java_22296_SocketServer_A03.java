import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;

public class java_22296_SocketServer_A03 {

    private SSLServerSocket serverSocket;
    private SSLSocket socket;

    public java_22296_SocketServer_A03(int port) throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream keystoreInputStream = getClass().getResourceAsStream("/keystore.jks");
        keyStore.load(keystoreInputStream, "password".toCharArray());
        context.init(keyStore, null, null);

        serverSocket = (SSLServerSocket) context.getServerSocket(port);
    }

    public void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = (SSLSocket) serverSocket.accept();
                    socket.setNeedClientAuth(true);
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    // handle input/output here

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        new SecureServer(4444).startServer();
    }
}