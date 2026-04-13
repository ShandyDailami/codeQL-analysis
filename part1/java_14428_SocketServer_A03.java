import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_14428_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);

            while (true) {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                Socket clientSocket = sslSocketFactory.createSocket(sslSocket.getInetAddress(), sslSocket.getPort());
                System.out.println("Client connected: " + clientSocket.getInetAddress() + " : " + clientSocket.getPort());

                Thread thread = new Thread(new ClientHandler(inputStream, outputStream, clientSocket));
                thread.start();
            }
        } catch (Exception ex) {
            Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class ClientHandler implements Runnable {

        private InputStream inputStream;
        private OutputStream outputStream;
        private Socket clientSocket;

        public java_14428_SocketServer_A03(InputStream inputStream, OutputStream outputStream, Socket clientSocket) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // read data from client and send it back to client
            try {
                byte[] bytes = new byte[1024];
                int length;
                while ((length = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }
                outputStream.flush();

                clientSocket.close();
            } catch (Exception ex) {
                Logger.getLogger(SecureSocketServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}