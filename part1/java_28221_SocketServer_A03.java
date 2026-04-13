import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_28221_SocketServer_A03 {
    private static final String CLIENT_IDENTIFIER = "TLSv1.2";
    private static SSLServerSocket serverSocket = null;

    public static void main(String[] args) {
        System.out.println("Starting Socket Server...");

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setEndpointIdentificationAlgorithm(CLIENT_IDENTIFIER);
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Injecting a backdoor to the server
                    // The following line is a placeholder, the actual implementation should be secure
                    if (message.equals("backdoor")) {
                        out.println("Access granted, entering backdoor mode...");

                        // Entering backdoor mode
                        out.println("Welcome backdoor user!");
                        out.flush();

                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                    String line;
                                    while ((line = br.readLine()) != null) {
                                        System.out.println("Backdoor mode: " + line);
                                   
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                    }
                }

                clientSocket.close();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex);
        }
    }
}