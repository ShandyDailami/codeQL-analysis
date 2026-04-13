import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_34304_SocketServer_A01 {

    private static SSLServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStream input;
    private static OutputStream output;

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, null);
        serverSocket.setNeedClientAuth(true);

        while (true) {
            clientSocket = serverSocket.accept();
            clientSocket.setNeedClientAuth(true);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAllCertsTrustManager()}, null);
            clientSocket.setSSLSocketFactory(sslContext.getSocketFactory());

            input = clientSocket.getInputStream();
            output = clientSocket.getOutputStream();

            handleRequest(input, output);
            clientSocket.close();
        }
    }

    private static void handleRequest(InputStream input, OutputStream output) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        DataOutputStream writer = new DataOutputStream(output);

        String request = reader.readLine();
        if (validateRequest(request)) {
            writeResponse(writer, "Valid request!");
        } else {
            writeResponse(writer, "Invalid request!");
        }
    }

    private static boolean validateRequest(String request) {
        // Implement your request validation logic here
        return true;
    }

    private static void writeResponse(DataOutputStream writer, String response) throws IOException {
        writer.writeBytes("HTTP/1.1 200 OK\r\n");
        writer.writeBytes("Content-Type: text/plain; charset=UTF-8\r\n");
        writer.writeBytes("Content-Length: " + response.length() + "\r\n");
        writer.writeBytes("\r\n");
        writer.writeBytes(response);
        writer.flush();
    }
}