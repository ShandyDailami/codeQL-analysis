import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_02500_SocketServer_A03 {
    private static final int PORT = 4446;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            sslServerSocket.setEnabledCipherSuites(new String[]{"TLSv1.2"});
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                sslSocket.setNeedClientAuth(true);
                Handler handler = new Handler(sslSocket);
                exec.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Handler extends Thread {
        private final SSLSocket socket;

        public java_02500_SocketServer_A03(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}