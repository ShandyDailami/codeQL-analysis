import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_05492_SocketServer_A07 {
    private static final String CLIENT_CERT = "src/main/resources/client.cert";
    private static final String CLIENT_KEY = "src/main/resources/client.key";
    private static final String CA_CERT = "src/main/resources/ca.cert";

    public static void main(String[] args) throws Exception {
        // Load client cert and key
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(new KeyStoreInputStream(CLIENT_CERT, CLIENT_KEY, "password".toCharArray()),
                new KeyStoreInputStream(CA_CERT, "password".toCharArray(), "password".toCharArray()), null);
        SSLServerSocket serverSocket = (SSLServerSocket) sslContext.getServerSocket(8000);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client accepted");
            // Create read and write buffers
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.write(("Received: " + message).getBytes());
                writer.newLine();
                writer.flush();
            }
            clientSocket.close();
        }
    }
}