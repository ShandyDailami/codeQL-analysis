import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34914_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server started, waiting for connections on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                int received;
                while ((received = input.read()) != -1) {
                    System.out.print((char) received);
                    output.write(received);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}