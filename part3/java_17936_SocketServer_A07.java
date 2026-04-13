import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_17936_SocketServer_A07 {
    private static SSLServerSocket sslServerSocket;
    private static Socket sslSocket;
    private static BufferedReader inFromClient;
    private static DataOutputStream outToClient;

    public static void main(String[] args) {
        // Create a SSLServerSocket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Waiting for client on port " + sslServerSocket.getLocalPort() + "...");

        while (true) {
            try {
                // Accept a client connection
                sslSocket = sslServerSocket.accept();
                SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sslSocket = (SSLSocket) sslSocketFactory.createSocket(sslSocket.getInetAddress(), sslSocket.getLocalPort());
                sslSocket.setNeedClientAuth(true);

                // Create input and output streams
                inFromClient = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                outToClient = new DataOutputStream(sslSocket.getOutputStream());

                // Perform authentication
                authenticate(inFromClient, outToClient);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void authenticate(BufferedReader inFromClient, DataOutputStream outToClient) {
        String inputLine;
        try {
            while ((inputLine = inFromClient.readLine()) != null) {
                System.out.println("Received: " + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Send a response back to the client
        try {
            outToClient.writeBytes("Authentication successful!\n");
            outToClient.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}