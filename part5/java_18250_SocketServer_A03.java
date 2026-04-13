import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_18250_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());
            serverSocket.setWantClientAuth(true);
            serverSocket.setClientID(CLIENT_IDENTIFIER);

            System.out.println("Waiting for client on port " + serverSocket.getLocalPort());

            while (true) {
                clientSocket = serverSocket.accept();
                clientSocket.setNeedClientAuthentication(true);
                clientSocket.setEnabledCipherSuites(clientSocket.getSupportedCipherSuites());

                System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected.");

                // Read from the client socket
                InputStream clientInput = clientSocket.getInputStream();
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientInput));

                // Write to the client socket
                OutputStream clientOutput = clientSocket.getOutputStream();
                PrintWriter clientWriter = new PrintWriter(clientOutput, true);

                // Communicate with the client
                String clientMessage;
                while ((clientMessage = clientReader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    clientWriter.println("Server response: " + clientMessage);
                }

                clientWriter.close();
                clientReader.close();
                clientSocket.close();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}