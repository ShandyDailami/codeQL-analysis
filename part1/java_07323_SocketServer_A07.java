import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;

public class java_07323_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a SSL Server Socket with a KeyStore
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(8443);
            sslServerSocket.setNeedClientAuth(true);

            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ssl/keystore"), "password".toCharArray());

            sslServerSocket.setKeyStore(keyStore);
            sslServerSocket.setKeyStorePassword("password");

            // Accept client connection
            Socket socket = sslServerSocket.accept();

            // Start a new thread for handling client
            new ClientHandler(socket).start();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static class ClientHandler extends Thread {
        private Socket socket;
        private InputStream input;
        private OutputStream output;

        public java_07323_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                input = socket.getInputStream();
                output = socket.getOutputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                    output.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}