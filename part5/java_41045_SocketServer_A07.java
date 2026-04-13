import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_41045_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Create a thread for each client connected to the server
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
                SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

                // Create a thread for each client for input/output operations
                Thread inputThread = new Thread(new SSLInput(sslIn));
                Thread outputThread = new Thread(new SSLOutput(sslOut));

                inputThread.start();
                outputThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sslServerSocket.close();
        }
    }
}

class SSLInput implements Runnable {
    private final InputStream in;

    public java_41045_SocketServer_A07(InputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, bytesRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SSLOutput implements Runnable {
    private final OutputStream out;

    public java_41045_SocketServer_A07(OutputStream out) {
        this.out = out;
    }

    public void run() {
        try {
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}