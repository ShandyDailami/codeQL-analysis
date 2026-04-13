import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServletOutputStream;
import java.security.cert.X509Certificate;

public class java_39961_SocketServer_A07 {
    private final int port;
    private final String password;

    public java_39961_SocketServer_A07(int port, String password) {
        this.port = port;
        this.password = password;
    }

    public void start() throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(port);
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setPassword(password.toCharArray());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Socket socket = null;
        try {
            socket = sslServerSocket.accept();
            System.out.println("Client connected");
            handle(socket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }

    private void handle(Socket socket) throws IOException {
        SSLSocket sslSocket = (SSLSocket) socket;
        X509Certificate cert = sslSocket.getSession().getPeerCertificate();

        System.out.println("Client Certificate: " + cert.toString());

        InputStream input = sslSocket.getInputStream();
        OutputStream output = sslSocket.getOutputStream();

        String request = "Hello Client!";

        output.write(request.getBytes());
        output.flush();

        byte[] bytes = new byte[1024];
        int bytesRead = input.read(bytes);
        String response = new String(bytes, 0, bytesRead);

        System.out.println("Server response: " + response);

        sslSocket.close();
    }

    public static void main(String[] args) {
        String password = "password"; // replace with your actual password
        try {
            new SocketServer(1234, password).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}