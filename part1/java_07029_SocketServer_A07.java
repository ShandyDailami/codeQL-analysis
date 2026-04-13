import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07029_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        OutputStream outputStream = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = reader.readLine();
        System.out.println("Received: " + message);

        if (message.equals("fail")) {
            outputStream.write("failure\n".getBytes());
            outputStream.flush();
            System.out.println("Auth failure, closing connection");
        } else {
            outputStream.write("success\n".getBytes());
            outputStream.flush();
            System.out.println("Auth success, closing connection");
        }

        socket.close();
    }
}