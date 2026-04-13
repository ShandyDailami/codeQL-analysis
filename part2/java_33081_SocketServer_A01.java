import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33081_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                if (message.equals("exit")) {
                    out.println("Server is shutting down");
                    socket.close();
                    serverSocket.close();
                    break;
                }

                out.println("Server received your message");
            }
        }
    }
}