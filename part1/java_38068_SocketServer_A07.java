import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38068_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            // Handle the request
            handleRequest(socket);
       
        }
    }

    private static void handleRequest(Socket socket) {
        // Here you would typically parse the request from the client,
        // verify the authentication, and then send a response back to the client.
        // For the sake of simplicity, we'll just echo back the received data.

        try {
            socket.getInputStream();

            // read the request
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String request = new String(buffer, 0, bytesRead);

            // echo the request back
            socket.getOutputStream().write(request.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}