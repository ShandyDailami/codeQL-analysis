import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_29173_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();
            DataInputStream dataInputStream = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(sslSocket.getOutputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Client says: " + message);
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            sslSocket.close();
        } catch (SSLException e) {
            e.printStackTrace();
        }
    }
}