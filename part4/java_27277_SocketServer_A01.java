import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_27277_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                socket = sslServerSocket.accept();

                SSLSocket sslSocket = (SSLSocket) socket.createChannel(socket.getInetAddress());
                sslSocket.startHandshake();

                SSLSession sslSession = sslSocket.getSession();
                System.out.println("Client " + sslSession.getRemoteSocketAddress() + " Connected");

                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream), true);

                String clientInput;
                while ((clientInput = reader.readLine()) != null) {
                    System.out.println("Received: " + clientInput);
                    writer.println("Server: Hello, Client!");
                }
            }
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}