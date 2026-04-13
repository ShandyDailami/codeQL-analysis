import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class java_07414_SocketServer_A07 {
    private int port;

    public java_07414_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Client says: " + line);

                // If client says something unsecured (like 'password' or similar), refuse connection
                if (line.equals("password")) {
                    socket.close();
                    System.out.println("Refused connection from " + socket.getRemoteSocketAddress());
                    continue;
                }

                // Otherwise, continue with secured operations
                // ...
            }

            socket.close();
            System.out.println("Connection closed from " + socket.getRemoteSocketAddress());
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(1234).start();
    }
}