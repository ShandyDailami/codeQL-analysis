import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_09730_SocketServer_A01 {
    private static SSLServerSocket sslServerSocket = null;
    private static DataInputStream dataInputStream = null;
    private static DataOutputStream dataOutputStream = null;

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            dataInputStream = new DataInputStream(sslSocket.getInputStream());
            dataOutputStream = new DataOutputStream(sslSocket.getOutputStream());

            String messageFromClient = dataInputStream.readUTF();
            System.out.println("Received message: " + messageFromClient);

            dataOutputStream.writeUTF("Hello, client!");
            dataOutputStream.flush();

            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}