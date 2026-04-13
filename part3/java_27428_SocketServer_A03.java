import java.io.*;
import java.net.*;
import java.util.*;

public class java_27428_SocketServer_A03 {
    private static final String SERVER_SOFTWARE = "SecureSocketServer";
    private static final int PORT = 4444;

    private static final int BUFFER_SIZE = 1024;

    private static void serve(ServerSocket socket) throws IOException {
        while (true) {
            Socket connection = socket.accept();
            handle(connection);
        }
    }

    private static void handle(Socket connection) throws IOException {
        PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        out.println("Server is ready.");

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            out.println("Echo: " + inputLine);
        }

        connection.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        server.setReuseAddress(true);

        System.out.println("Server started at port " + PORT);

        serve(server);
    }
}