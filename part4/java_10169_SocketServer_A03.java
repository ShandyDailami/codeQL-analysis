import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_10169_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            sslServerSocket.setNeedClientAuthentication(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new File[]{new KeyStore("server_keystore.jks", "password").storeAsPKCS12()}, null);
            sslServerSocket.setSSLContext(sslContext);
            while (true) {
                Socket socket = sslServerSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
                new SSLInput(socket).start();
            }
        } finally {
            sslServerSocket.close();
        }
    }

    private static class SSLInput extends Thread {
        Socket socket;
        InputStream inputStream;

        SSLInput(Socket socket) {
            this.socket = socket;
            inputStream = socket.getInputStream();
            start();
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}