import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_41789_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            socket = (SSLSocket) serverSocket.accept();

            socket.startHandshake();
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Client connected");

            String clientInput;
            while ((clientInput = in.readLine()) != null) {
                System.out.println("Received: " + clientInput);

                // Here, we'll simulate an integrity failure by assuming if the input string is
                // "bad", we should send a response with "bad" in it.
                if ("bad".equals(clientInput)) {
                    out.println("Bad data received, integrity failure.");
                } else {
                    out.println("Data received, integrity OK.");
                }

                out.flush();
            }
        } finally {
            socket.close();
            serverSocket.close();
        }
    }
}