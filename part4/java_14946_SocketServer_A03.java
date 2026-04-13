import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_14946_SocketServer_A03 {

    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "password_for_your_keystore";
    private static final String KEY_PASSWORD = "password_for_your_key";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "password_for_your_truststore";

    public static void main(String[] args) throws Exception {
        runServer(true);
    }

    private static void runServer(boolean useSsl) throws IOException {
        ServerSocket serverSocket = null;
        if (useSsl) {
            serverSocket = createSslServerSocket(8443, KEYSTORE_LOCATION, KEYSTORE_PASSWORD, KEY_PASSWORD, TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD);
        } else {
            serverSocket = new ServerSocket(8080);
        }

        while (true) {
            Socket socket = serverSocket.accept();
            processRequest(socket);
        }
    }

    private static ServerSocket createSslServerSocket(int port, String keystoreLocation, String keystorePassword, String keyPassword, String truststoreLocation, String truststorePassword) throws IOException {
        InputStream keystoreInputStream = readInputStream(keystoreLocation, keystorePassword);
        SSLServerSocket sslServerSocket = new SSLServerSocket(port, keystoreInputStream, keyPassword, truststoreInputStream, truststorePassword);
        return sslServerSocket;
    }

    private static InputStream readInputStream(String keystoreLocation, String password) throws IOException {
        return new java.io.FileInputStream(keystoreLocation).getInputStream();
    }

    private static OutputStream getOutputStream(Socket socket) throws IOException {
        return socket.getOutputStream();
    }

    private static void processRequest(Socket socket) throws IOException {
        SSLSocket sslSocket = (SSLSocket) socket.getSocket();
        sslSocket.setNeedClientAuth(true);
        sslSocket.startHandshake();
        OutputStream outputStream = getOutputStream(sslSocket);
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        outputStream.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
        outputStream.write("\r\n".getBytes());
        outputStream.write("Hello, World!!".getBytes());
        outputStream.flush();
        sslSocket.close();
    }
}