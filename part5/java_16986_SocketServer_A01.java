import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_16986_SocketServer_A01 {

    private static final String CLIENT_PASSWORD = "mypassword";

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                socket = sslServerSocket.accept();
                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress(), socket.getPort());
                sslSocket.setNeedClientAuth(true);

                // SSL/TLS handshake
                SSLSession session = sslSocket.getSession();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Password protection
                String password = reader.readLine();
                if (!password.equals(CLIENT_PASSWORD)) {
                    writer.println("Invalid password");
                    writer.flush();
                    continue;
                }

                // Authentication
                if (session.getProtocol().equals(SSLSession.VERSION_SSLv2) || session.getProtocol().equals(SSLSession.VERSION_SSLv3)
                        || session.getProtocol().equals(SSLSession.VERSION_TLS)) {
                    sslSocket.close();
                    writer.println("Not using TLS/SSL");
                    writer.flush();
                    continue;
                }

                // Continue with the rest of the authentication...

                // ... after the authentication process

                // Write a response
                writer.println("Hello, client!");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}