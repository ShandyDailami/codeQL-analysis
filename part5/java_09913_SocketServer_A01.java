import java.io.*;
import java.net.*;

public class java_09913_SocketServer_A01 {
    private static final int port = 1234;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket socket = server.accept();
            count++;
            System.out.println("Connection number: " + count);
            handleConnection(socket);
        }
    }

    private static void handleConnection(Socket socket) throws IOException {
        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            writer.println("Hello client, you connected with number: " + count);
        }
        socket.close();
    }
}