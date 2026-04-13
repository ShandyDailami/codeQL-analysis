import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_08100_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(6000);
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(sslSocket.getOutputStream());

        String message;
        while ((message = in.readLine()) != null) {
            out.writeUTF("Echo: " + message);
            out.flush();
        }

        sslSocket.close();
    }
}