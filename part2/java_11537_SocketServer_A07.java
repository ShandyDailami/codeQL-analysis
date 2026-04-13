import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11537_SocketServer_A07 {
    private static final String SSL_PORT = "9999";
    private static SSLServerSocket serverSocket = null;

    public static void main(String[] args) throws Exception {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));

            System.out.println("Server started at port " + SSL_PORT);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says: " + message);

                // Authenticate the client
                if (!authenticate(clientSocket, in, out)) {
                    System.out.println("Authentication failed");
                    out.writeUTF("Authentication failed");
                    clientSocket.close();
                    continue;
                }

                out.writeUTF("Server says: Hello, Client!");
                clientSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean authenticate(SSLSocket socket, DataInputStream in, DataOutputStream out) throws IOException {
        SSLSession session = socket.getSession();
        SSLPeerAuthenticationPrompt pa = session.getPeerAuthenticationPrompt();

        if (pa != null) {
            pa.prompt();

            String certAlias = pa.getCertificateAlias();
            if (certAlias == null) {
                out.writeUTF("No Certificate Alias");
                return false;
            }

            out.writeUTF("Authenticated with: " + certAlias);
            return true;
        }

        return false;
    }
}