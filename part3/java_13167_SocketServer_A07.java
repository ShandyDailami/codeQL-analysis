import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_13167_SocketServer_A07 {

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            System.out.println("Could not create SSL Server socket");
            e.printStackTrace();
        }

        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected");

                SSLSession sslSession = clientSocket.getSession();
                if (!(sslSession instanceof Authenticator)) {
                    sslSession.close();
                    continue;
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String userInput;
                while ((userInput = in.readLine()) != null) {
                    System.out.println("Received: " + userInput);
                    out.println("Hello, " + userInput);
                }
                sslSession.close();

            } catch (IOException e) {
                System.out.println("Error in reading from or writing to client socket");
                e.printStackTrace();
            }
        }
    }
}