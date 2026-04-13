import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.security.auth.x500.X500Principal;

public class java_21207_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) SSLServerSocket.create(8080);
            serverSocket.setNeedClientAuth(true);
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake();
            X509Certificate[] chain = socket.getSessionKeys();
            Principal[] principals = chain[0].getSubjects();
            X500Principal subject = (X500Principal) principals[0];
            PrivateKey privateKey = chain[0].getPrivateKey();
            System.out.println("Client: " + subject.getName());
            // TODO: Perform security-sensitive operations here
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}