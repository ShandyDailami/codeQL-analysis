import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_04856_SocketServer_A01 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        int port = 8888;
        ServerSocket socket = new ServerSocket(port);
        socket.setEnabledCipherSuites(new String[] {
            "TLSv1", "TLSv1.1", "TLSv1.2"
        });

        SSLServerSocket factory = (SSLServerSocket) socket;
        factory.setNeedClientAuth(true);

        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, null);

        serverSocket = (SSLServerSocket) context.getServerSocket(factory);
        serverSocket.setSoTimeout(60000);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setSoTimeout(60000);

            OutputStream out = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello from server!");

            SSLInputStream in = (SSLInputStream) clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}