import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_32366_SocketServer_A03 {
    private static final String CLIENT_MESSAGE = "Hello from client!";
    private static SSLServerSocket serverSocket = null;

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Create a SSLServerSocket with SSL enabled
            SSLServerSocket server = new SSLServerSocket(8080, null, null, SSLServerSocket.getDefaultSSLParameters());
            serverSocket = server;

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());

                // Create input and output streams
                OutputStream out = socket.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                writer.write(CLIENT_MESSAGE);
                writer.newLine();
                writer.flush();

                InputStream in = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = reader.readLine();
                System.out.println("Received: " + line);

                socket.close();
            }
        } finally {
            serverSocket.close();
        }
    }
}