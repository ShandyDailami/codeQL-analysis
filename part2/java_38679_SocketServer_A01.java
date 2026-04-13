import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_38679_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket sock = new ServerSocket(12345);
        SSLServerSocket serverSock = (SSLServerSocket) sock;
        serverSock.setEnabled(true);
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new TrustManager[] {new TrustAllCerts()}, null);
        serverSock.setSSLContext(context);

        System.out.println("Waiting for client connections...");
        Socket client = serverSock.accept();
        System.out.println("Connected to " + client.getRemoteSocketAddress());

        OutputStream out = client.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Hello client, Welcome to Secure Server!");

        client.close();
    }
}