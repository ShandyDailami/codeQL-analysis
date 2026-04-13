import java.net.*;
import javax.net.ssl.*;

public class java_41987_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.setNeedClientAuth(true);

                SSLPeerConnection pc = (SSLPeerConnection) clientSocket;
                SSLSession sslSession = pc.getSession();

                System.out.println("Client connected. SSL Session ID: " + sslSession.getSessionID());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Hello Client, You are connected to Secure Server!");
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }
}