import java.io.*;
import java.net.*;

public class java_31033_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String input;
            while ((input = in.readLine()) != null) {
                if (isUserValid(input)) {
                    out.println("Access granted");
                } else {
                    out.println("Access denied");
                }
            }
            socket.close();
        }
    }

    private static boolean isUserValid(String user) {
        // Remove this line and replace with real logic for checking user validity
        // This is just a mock-up for illustration
        return true;
    }
}