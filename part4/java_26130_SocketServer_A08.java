import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_26130_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;

        // Load the server's key and certificate
        SSLServerKeyStoreServerCertificate keyStore = new SSLServerKeyStoreServerCertificate(
                "src/server.jks", // Key store file
                "server-key", // Key store password
                "password", // Key password
                null); // Trust store file

        SSLServerSocketFactory sslServerSocketFactory = keyStore.getServerSocketFactory();

        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setUseClientMode(true);

        System.out.println("Waiting for client on port " + sslServerSocket.getPort());

        while (true) {
            sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.setNeedClientAuth(true);
            sslSocket.setUseClientMode(true);

            System.out.println("Client connected from " + sslSocket.getRemoteSocketAddress());

            // Send a greeting to the client
            OutputStream out = sslSocket.getOutputStream();
            DataOutputStream outToClient = new DataOutputStream(out);
            outToClient.writeUTF("Connection established");

            // Receive a request from the client and send a response
            InputStream in = sslSocket.getInputStream();
            DataInputStream inFromClient = new DataInputStream(in);
            String request = inFromClient.readUTF();
            System.out.println("Received: " + request);

            outToClient.writeUTF("Thank you for connecting, " + request);
            sslSocket.close();
       
        }

    }

}