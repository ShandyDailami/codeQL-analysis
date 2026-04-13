import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_22127_SocketServer_A03 {

    private static final String CLIENT_KEY_PATH = "/path_to_key_file";
    private static final String CLIENT_CERT_PATH = "/path_to_cert_file";

    public static void main(String[] args) throws Exception {
        ServerSocket socketserver = new ServerSocket(6000);
        socketserver.setReuseAddress(true);
        SSLServerSocket serverSocket = null;

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(new SSLServerSocketFactory(new KeyStoreInputStream(CLIENT_CERT_PATH, CLIENT_KEY_PATH), null, null),
            new String[] {"TLSv1", "TLSv2", "TLSv3"}, null, SSLConnection.SELECT_SSL);
        serverSocket = (SSLServerSocket) socketserver;
        serverSocket.setNeedClientAuth(true);

        System.out.println("Secure Server Started");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());

            InputStream inputStream = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(inputStream);
            PrintStream out = new PrintStream(clientSocket.getOutputStream());

            String clientQuery = dis.readUTF();

            if ("ping".equalsIgnoreCase(clientQuery)) {
                out.println("pong");
                out.flush();
            }

            clientSocket.close();
        }
    }
}