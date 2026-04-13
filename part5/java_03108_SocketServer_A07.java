import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.ServerSocket;

public class java_03108_SocketServer_A07 {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public java_03108_SocketServer_A07(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            clientSocket = serverSocket.accept();
            System.out.println("A client has connected");

            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();

            byte[] bytes = new byte[1000];
            int length;

            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(5000);
    }
}