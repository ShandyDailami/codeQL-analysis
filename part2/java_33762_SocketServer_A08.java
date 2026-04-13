import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_33762_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        runServer(false);
    }

    public static void runServer(boolean useSSL) throws IOException {
        if (useSSL) {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setUseClientMode(true);

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Client says: " + line);
                output.write((line + "\n").getBytes());
                output.flush();
            }

            socket.close();
        } else {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();

            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Client says: " + line);
                output.write((line + "\n").getBytes());
                output.flush();
            }

            socket.close();
        }
    }
}