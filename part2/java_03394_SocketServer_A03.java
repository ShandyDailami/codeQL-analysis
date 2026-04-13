import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03394_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        // SSL Server
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, SSLServerSocket.SELECT_CHANNEL);
        serverSocket.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, null, null);

        while (true) {
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);
            socket.setUseClientMode(true);

            SSLSession sslSession = socket.getSession();
            sslSession.setUseClientMode(true);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Here is where you would handle the data received from the client
            String data = reader.readLine();
            System.out.println("Received: " + data);

            writer.write("Hello Client".getBytes());
            writer.flush();
       
            socket.close();
        }
    }
}