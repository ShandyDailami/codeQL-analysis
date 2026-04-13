import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04382_SocketServer_A07 {

    private static final int port = 12345;

    public static void main(String[] args) throws Exception {

        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;
        Socket connection = null;

        try {
            // Set up SSL context
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);

            // Set up server socket
            socket = new ServerSocket(port);
            socket.setReuseAddress(true);

            // Set up SSL server socket
            sslSocket = (SSLServerSocket) context.getServerSocketFactory().createServerSocket(port);
            sslSocket.setReuseAddress(true);

            // Accept client connection
            connection = sslSocket.accept();

            // Set up input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());

            // Send a hello message
            out.writeUTF("Hello, client!");
            out.flush();

            // Get and print a response from the client
            String message = in.readLine();
            System.out.println("Server says: " + message);

            // Close connections
            in.close();
            out.close();
            connection.close();
            sslSocket.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure all streams are closed
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (sslSocket != null) {
                try {
                    sslSocket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}