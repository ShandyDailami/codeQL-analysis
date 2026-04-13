import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_15346_SocketServer_A03 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "_CBC_PKCS5PADDING";
    private static final byte[] INITIALIZATION_VECTOR = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

    public static Socket acceptSocket(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        socket.setNeedClientAuth(true);
        return socket;
    }

    public static SSLServerSocket createSSLServerSocket(int port) throws IOException {
        SSLServerSocket serverSocket = new SSLServerSocket(port);
        serverSocket.setNeedClientAuth(true);
        return serverSocket;
    }

    public static SSLSocket createSSLSocket(Socket socket, SSLServerSocket serverSocket) throws IOException {
        SSLSocket sslSocket = null;
        SSLSocketFactory sslSocketFactory = serverSocket.getSocketFactory();
        sslSocket = (SSLSocket) sslSocketFactory.createSocket(socket, serverSocket.getInetAddress(), serverSocket.getPort(), true);
        sslSocket.setNeedClientAuth(true);
        return sslSocket;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = createSSLServerSocket(443);
        Socket socket = acceptSocket(serverSocket);
        SSLSocket sslSocket = createSSLSocket(socket, serverSocket);

        sslSocket.setUseClientMode(true);
        sslSocket.startHandshake();

        byte[] data = "Hello, Client!".getBytes();
        sslSocket.write(data);
        sslSocket.close();
    }
}