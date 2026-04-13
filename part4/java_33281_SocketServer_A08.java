import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_33281_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.setNeedClientAuthentication(true);

                SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(clientSocket, serverSocket.getInetAddress(), serverSocket.getPort(), true);

                sslSocket.setNeedClientAuth(true);
                sslSocket.setEnabledCipherSuites(sslSocket.getSupportedCipherSuites());

                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    out.println("Successfully processed the request");
                }
           
            }
        } finally {
            clientSocket.close();
            serverSocket.close();
        }
    }
}