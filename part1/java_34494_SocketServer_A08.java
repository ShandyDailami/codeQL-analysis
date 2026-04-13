import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34494_SocketServer_A08 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket socket;

    public static void main(String[] args) throws IOException {
        // Creating SSLServerSocket and SSLSocket
        SSLServerSocket server = new SSLServerSocket(8080, null, null, SSLServerSocket.getDefaultSSLSocketFactory());
        socket = (SSLSocket) server.accept();
        socket.setEnabledCipherSuites(server.getSupportedCipherSuites());
        socket.setEnabledKeyAlgorithms(server.getSupportedKeyAlgorithms());

        System.out.println("Connected to: " + socket.getRemoteSocketAddress());

        OutputStream outToClient = socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToClient);

        // Sending response
        out.writeUTF("Thank you for connecting to the server");
        out.flush();

        // closing streams
        out.close();
        socket.close();
        server.close();
    }
}