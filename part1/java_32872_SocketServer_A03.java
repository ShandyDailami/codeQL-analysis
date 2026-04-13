import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_32872_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 8080;
        System.out.println("Starting server on port " + port);

        while (true) {
            try {
                Socket socket = new Socket("localhost", port);
                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Please enter your name: ");
                String name = in.readLine();
                out.println("Hello, " + name + "!");

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}