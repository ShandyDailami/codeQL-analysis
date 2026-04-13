import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_39649_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client authentication...");

            clientSocket = serverSocket.accept();
            System.out.println("Client accepted!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String user = in.readLine();
            String pass = in.readLine();

            if ("username".equals(user) && "password".equals(pass)) {
                System.out.println("Authentication successful, proceeding...");
                out.println("Authentication successful");
            } else {
                System.out.println("Authentication failed, closing connection...");
                out.println("Authentication failed");
                clientSocket.close();
            }

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}