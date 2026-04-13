import javax.net.ssl.*;
import java.net.*;
import java.io.*;

public class java_16016_SocketServer_A03 {

    private static SSLServerSocket sslServerSocket = null;
    private static Socket socket = null;

    public static void main(String[] args) {
        int port = 8888;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            while (true) {
                socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();

                SSLHandler sslHandler = new SSLHandler(sslSocket);
                new Thread(sslHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
            sslServerSocket.close();
        }
    }
}

class SSLHandler implements Runnable {

    private final SSLSocket socket;

    public java_16016_SocketServer_A03(SSLSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}