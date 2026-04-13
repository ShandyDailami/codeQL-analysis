import java.io.*;
import java.net.*;

public class java_22332_SocketServer_A01 {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "pass";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            server = new ServerSocket(8080);
            System.out.println("Waiting for client...");

            socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            out = new PrintWriter(socket.getOutputStream(), true);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String username = in.readLine();
            String password = in.readLine();

            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                out.println("Welcome to the server!");
            } else {
                out.println("Access denied!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}