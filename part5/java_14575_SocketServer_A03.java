import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_14575_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setEnabledSSLVersions(SSLServerSocket.DEFAULT_SSL_PORT);

            System.out.println("Waiting for client on port 8080...");
            socket = sslServerSocket.accept();
            System.out.println("Client connected");

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            DataInputStream dis = new DataInputStream(inputStream);
            DataOutputStream dos = new DataOutputStream(outputStream);

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client!";
            dos.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
            sslServerSocket.close();
        } finally {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}