import java.net.Socket;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocketFactory;
import org.bouncycastle.asn1.x509.SubjectAlternativeName;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509CertificateInfo;
import org.bouncycastle.cert.X509CertificateStructure;
import org.bouncycastle.cert.X509ExtensionUtils;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMAC256;
import org.bouncycastle.crypto.params.KeyGenerationParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.asymmetric.RSAPrivateCrtKeyParameters;
import org.bouncycastle.crypto.params.asymmetric.RSAPublicKeyParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class java_40004_SocketServer_A07 {

    private static class Authenticator extends javax.net.ssl.SSLSocket.Authentication {
        private final String clientHello;

        Authenticator(String clientHello) {
            this.clientHello = clientHello;
        }

        @Override
        public boolean isClientHelloSupported(String s) {
            return true;
        }

        @Override
        public String chooseClientAlias(String[] strings, Socket socket) {
            return strings[0];
        }

        @Override
        public String chooseServerAlias(String[] strings, Socket socket) {
            return strings[0];
        }

        @Override
        public void startHandshake() {
        }

        @Override
        public void processDatagram(byte[] bytes, int i, int i1, Socket socket) {
        }

        @Override
        public void done() {
        }

        @Override
        public String getClientVersion() {
            return clientHello;
        }

        @Override
        public String getServerVersion() {
            return clientHello;
        }
    }

    public static void main(String[] args) {
        try {
            Logger.getLogger("org.bouncycastle").setLevel(Level.WARNING);
            java.util.logging.Logger bcLogger = java.util.Logger.getLogger("org.bouncycastle");
            bcLogger.setLevel(Level.WARNING);

            SSLServerSocketFactory sslsf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            Socket socket = sslsf.createSocket(9999);
            socket.setSoTimeout(60000);
            socket.setReuseAddress(true);

            socket.setAuthentication(true);
            socket.setSoTimeout(60000);
            socket.setReuseAddress(true);

            socket.bind(null);

            Thread t = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            Socket sock = socket.accept();
                            sock.getInputStream().close();
                            sock.getOutputStream().close();
                            sock.close();
                        } catch (Exception e) {
                        }
                    }
                }
            };
            t.setDaemon(true);
            t.start();

            Authenticator auth = new Authenticator() {
                @Override
                protected byte[] generateServerHello(String s, int i, byte[] bytes, byte[] bytes1, int i1, int i2) {
                    return bytes;
                }

                @Override
                protected byte[] generateClientHello(String s, int i, byte[] bytes, byte[] bytes1, int i1, int i2) {
                    return bytes;
                }

                @Override
                public boolean isClientHelloSupported(String s) {
                    return true;
                }

                @Override
                public boolean isServerHelloSupported(String s) {
                    return true;
                }
            };

            socket.setAuthentication(auth);
            socket.startHandshake();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}