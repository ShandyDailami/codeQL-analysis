import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class java_32760_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10000);

        serverSocket.setNeedClientAuth(true);
        sslServerSocketFactory.setKeyStorePath("path_to_keystore");
        sslServerSocketFactory.setKeyStorePassword("password_for_keystore");
        sslServerSocketFactory.setKeyStoreType("JKS");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Write the response back to the client
            output.write("Hello, client\n".getBytes());
            output.flush();

            clientSocket.close();
        }
    }
}