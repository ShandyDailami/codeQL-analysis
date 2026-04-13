import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_27559_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket sockets = new ServerSocket(8000);
        SSLServerSocket serverSock = (SSLServerSocket) sockets;
        serverSock.setNeedClientAuth(true);

        SSLContext context = SSLContext.getInstance("SSL");
        context.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
        SSLServerSocket secureSock = (SSLServerSocket) context.getServerSocket(serverSock);

        while (true) {
            Socket socket = secureSock.accept();
            System.out.println("Connection accepted from " + socket.getInetAddress().toString());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection successful");
            socket.close();
        }
    }
}

class TrustAnyTrustManager implements X509TrustManager {
    public boolean checkClientTrusted(X509Certificate[] chain, String authType) {
        return true;
    }

    public boolean checkServerTrusted(X509Certificate[] chain, String authType) {
        return true;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}