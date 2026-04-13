import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_17356_SocketServer_A07 {
    private final int port;
    private SSLServerSocket sslServerSocket;

    public java_17356_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocket sslServer = (SSLServerSocket) new SSLServerSocket(port);
            sslServer.setNeedClientAuth(true);
            sslServerSocket = sslServer;

            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("New client connected");
                new ClientHandler(sslSocket).start();
            }
        } finally {
            sslServerSocket.close();
        }
    }

    private class ClientHandler extends Thread {
        private final SSLSocket socket;

        public java_17356_SocketServer_A07(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SSLPeerPrincipal peerPrincipal = socket.getPeerPrincipal();
                System.out.println("Client cert details: " + peerPrincipal.toString());

                SSLCertificate clientCert = (SSLCertificate) peerPrincipal.getCertificates()[0];
                System.out.println("Client cert details: " + clientCert.toString());

                socket.setNeedClientAuth(true);
                socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());
                socket.setEnabledProtocols(socket.getProtocol());

                SSLSession session = socket.getSession();
                SSLSessionContext sslSessionContext = session.getSessionContext();
                sslSessionContext.setSessionTimeout(10000);

                OutputStream out = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("Hello from server!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new SecureServer(8443).start();
    }
}