import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_10698_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create SSLServerSocket and bind it to port 8080
            serverSocket = new ServerSocket(8080);
            sslServerSocket = (SSLServerSocket) serverSocket.accept();

            // Create InputStream and OutputStream for SSLConnection
            SSLInputStream sslIn = new SSLInputStream(sslServerSocket.getInputStream());
            SSLOutputStream sslOut = new SSLOutputStream(sslServerSocket.getOutputStream());

            // Create SSLContext with default parameters
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] { new TrustAllCertificates() }, null);

            // Setup SSLConnection with SSLContext
            SSLConnection sslConnection = new SSLConnection(sslContext, sslOut, sslIn);

            // Setup InputStreamReader and BufferedReader for sslConnection
            InputStreamReader isr = new InputStreamReader(sslConnection.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String clientInput;

            while ((clientInput = br.readLine()) != null) {
                System.out.println("Received: " + clientInput);
                sslConnection.shutdownInput();

                System.out.println("Sending: " + clientInput);
                sslConnection.getOutputStream().write((clientInput + "\n").getBytes());
                sslConnection.getOutputStream().flush();
            }

            sslConnection.shutdownOutput();
            sslConnection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}