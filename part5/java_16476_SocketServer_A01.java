import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_16476_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket sock = new ServerSocket(4444);
        SSLServerSocket serverSocket = (SSLServerSocket) sock;
        serverSocket.setNeedClientAuth(true);

        SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
        sslcontext.init(null, null, null);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuth(true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Send server's public key
            out.write("-----BEGIN PUBLIC KEY-----\n".getBytes());
            out.write(sslcontext.getPublicKey().getEncoded());
            out.write("\n-----END PUBLIC KEY-----\n".getBytes());
            out.flush();

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            clientSocket.close();
        }
    }
}