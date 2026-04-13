import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_02144_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            // Step 1: Setup the SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = new ServerSocket(4444);
            sslSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444, null, null, socket);

            // SSL Initialization
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[] {new TrustManagerSSL()}, null);
            sslSocket.setSSLSocket(new SSLSocket(sslSocket.getSocket()));
            sslSocket.getSocket().setSSLSocket(sslSocket);
            sslSocket.setNeedClientAuth(true);

            // Step 2: Accept and handle connections
            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslSocket.accept();
                new EchoHandler(clientSocket).start();
            }
        } finally {
            if (socket != null) socket.close();
            if (sslSocket != null) sslSocket.close();
        }
    }

    private static class EchoHandler extends Thread {
        private final Socket socket;
        private final DataOutputStream out;
        private final DataInputStream in;

        public java_02144_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                return;
            }
        }

        public void run() {
            try {
                while (true) {
                    String msg = in.readUTF();
                    out.writeUTF(msg);
                    out.flush();
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class TrustManagerSSL implements X509TrustManager {

        public java_02144_SocketServer_A03() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }

    }
}