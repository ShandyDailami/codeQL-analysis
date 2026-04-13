import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_15275_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuthentication(true);

            SSLSocket sslSocket = null;
            while (true) {
                sslSocket = sslServerSocket.accept();
                System.out.println("Client accepted: " + sslSocket.getRemoteSocketAddress());

                // Set up SSL handshake
                SSLSession sslSession = sslSocket.getSession();
                sslSession.setNeedClientAuth(true);
                sslSession.setUseClientMode(true);

                // Perform handshake
                sslSocket.startHandshake();

                // Print the handshake result
                System.out.println("Handshake result: " + sslSession.getProtocol());

                // Now you can read/write data from/to client
                OutputStream out = sslSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello client, you are connected to the server!");
            }
        } finally {
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}