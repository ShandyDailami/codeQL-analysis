import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_31495_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static SSLServerSocket sslServerSocket = null;
    private static Socket sslSocket = null;
    private static InputStream inFromClient;
    private static OutputStream outToClient;

    public static void main(String[] args) {

        try {
            // Setup SSL server
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Accept client connection
            sslSocket = sslServerSocket.accept();

            // Setup input and output streams
            sslSocket.setNeedClientAuth(true);
            sslServerSocket.setNeedClientAuth(true);
            inFromClient = sslSocket.getInputStream();
            outToClient = sslSocket.getOutputStream();

            // Write auth response
            writeAuthResponse(outToClient);

            // Handle client requests
            handleRequests(inFromClient, outToClient);

            // Close resources
            sslServerSocket.close();
            sslSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequests(InputStream inFromClient, OutputStream outToClient) {

        BufferedReader in = new BufferedReader(new InputStreamReader(inFromClient));
        PrintWriter out = new PrintWriter(outToClient, true);
        String line;

        try {
            // Read requests and write responses
            while ((line = in.readLine()) != null) {
                out.println("Echo: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeAuthResponse(OutputStream outToClient) {

        try {
            Writers writer = new Writers(outToClient);
            writer.writeString("SSL/TLS Client Auth");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Writers {

    private OutputStream out;

    public java_31495_SocketServer_A07(OutputStream out) {
        this.out = out;
    }

    public void writeString(String s) {
        try {
            out.write((s + "\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}