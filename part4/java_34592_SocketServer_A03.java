import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_34592_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a SSLServerSocket with SSL enabled
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444);
        sslServerSocket.setNeedClientAuthentication(true);

        // Accept incoming client
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        // Get the SSL input and output streams
        SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
        SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

        // Create an SSLContext
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new X509Certificate[]{}, new KeyStore[]{});

        // Create a new SSLSocketFactory using the SSLContext
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create a BufferedReader to read the input
        BufferedReader sslInReader = new BufferedReader(new InputStreamReader(sslIn));

        // Create a PrintWriter to write the output
        PrintWriter sslOutWriter = new PrintWriter(sslOut, true);

        // Create a Thread for reading and writing
        Thread sslReadWriteThread = new Thread(new Runnable() {
            public void run() {
                try {
                    String readLine;
                    while ((readLine = sslInReader.readLine()) != null) {
                        System.out.println("Client says: " + readLine);
                        sslOutWriter.println("Server says: " + readLine);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the read and write threads
        sslReadWriteThread.start();

        // Close the server socket
        sslServerSocket.close();
    }
}