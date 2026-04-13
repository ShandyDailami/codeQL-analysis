import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_21122_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request = in.readLine();
                System.out.println("Server received: " + request);

                // Authentication
                SSLSession sslSession = clientSocket.getSession();
                sslSession.setNeedClientAuth(true);

                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                out.flush();
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }
}