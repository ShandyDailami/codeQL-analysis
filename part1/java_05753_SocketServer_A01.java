import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_05753_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        try {
            socket = (ServerSocket) new SSLServerSocket(8080);
            while (true) {
                Socket connection = socket.accept();
                System.out.println("Accepted connection from " + connection.getRemoteSocketAddress());
                new SecureServerThread(connection).start();
            }
        } finally {
            socket.close();
        }
    }
}

class SecureServerThread extends Thread {
    private Socket socket;
    public java_05753_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuthentication(true);
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new String[] { "SSL_client_key.pem", "SSL_client_cert.pem" }, null);
            sslSocket.setSSLContext(sslContext);
            BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
            PrintWriter outWriter = new PrintWriter(out, true);
            String line;
            while ((line = inReader.readLine()) != null) {
                outWriter.println("Server received: " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}