import java.io.IOException;
import java.net.InetSocketAddr;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import javax.net.ssl.*;

public class java_22519_SocketServer_A08 {

    private SSLServerSocket sslServerSocket;
    private SSLSocket sslSocket;
    private SSLContext sslContext;

    public java_22519_SocketServer_A08() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "password".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunKeyManagerFactory");
            keyManagerFactory.init(keyStore, "password".toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509TrustManager");
            trustManagerFactory.init(keyStore);

            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory, trustManagerFactory, null);

            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);
            sslServerSocket.setOption(StandardSocketOptions.SO_REUSEADDR, true);

            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            sslSocket.setNeedClientAuth(true);

            SocketChannel clientChannel = sslSocket.getChannel();
            clientChannel.configureBlocking(false);
            clientChannel.setOption(ChannelOption.IP_TOS, IPv4Tos.forLinux(1));

            sslSocket.startHandshake();

            while (true) {
                byte[] bytes = new byte[1024];
                int len = clientChannel.read(bytes);
                if (len == -1) {
                    break;
                }
                clientChannel.write(bytes, new InetSocketAddr(8443));
            }

            sslServerSocket.close();
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureServer();
    }
}