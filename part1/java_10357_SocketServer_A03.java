import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10357_SocketServer_A03 {
    private static final String CLIENT_HASH = "SHA-256";
    private static final String SERVER_KEY = "server-key.pem";
    private static final String SERVER_CERT = "server-cert.pem";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance(CLIENT_HASH);
            keyStore.load(new FileInputStream(SERVER_KEY), "password".toCharArray());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyStore, null, null);
            serverSocket.setSSLContext(sslContext);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new MyServerThread(clientSocket).start();
            }
        } finally {
            serverSocket.close();
        }
    }
}

class MyServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_10357_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            // Handle exception
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            // Handle exception
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // Handle exception
            }
        }
    }
}