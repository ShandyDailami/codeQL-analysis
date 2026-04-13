import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_35848_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        boolean useTLS = args.length == 1 && args[0].equals("noTLS");
        SSLServerSocket serverSocket = null;
        if (useTLS) {
            serverSocket = (SSLServerSocket) new ServerSocket(4444); // port
            serverSocket.setNeedClientAuth(true);
        } else {
            serverSocket = (ServerSocket) new ServerSocket(4444); // port
        }

        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected!");

        if (useTLS) {
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.setNeedClientAuth(true);

            OutputStream out = sslSocket.getOutputStream();
            out.write("Connected to server\n".getBytes());
        } else {
            OutputStream out = socket.getOutputStream();
            out.write("Connected to server\n".getBytes());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Received: " + line);
        }

        socket.close();
        serverSocket.close();
    }
}