import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04776_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("A07_AuthFailure")) {
                    out.println("Authentication failure, please try again.");
                    out.flush();
                } else {
                    out.println("Server received: " + message);
                    out.flush();
                }
            }

            socket.close();
        }
    }
}