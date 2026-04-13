import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07210_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Bypass the client by setting the request to a specific value.
            // This is a very basic form of injection, but it's not recommended in real applications.
            if ("inject me if you want".equals(request)) {
                request = "You are injected!";
            }

            outputStream.write(request.getBytes());
            outputStream.newLine();
            outputStream.flush();
        }
    }
}