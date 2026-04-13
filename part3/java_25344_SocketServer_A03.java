import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_25344_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Server is ready for authentication");
            String response = in.readLine();
            int randomNumber = Integer.parseInt(response.substring(response.indexOf(' ') + 1));

            out.println("Server is verifying client's identity. Random number: " + randomNumber);

            if (randomNumber == Integer.parseInt(args[0])) {
                out.println("Authentication successful. Connection established.");
            } else {
                out.println("Authentication failed. Connection closed.");
           
            }

            out.close();
            clientSocket.close();

        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}