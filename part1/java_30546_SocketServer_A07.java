import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30546_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            while (true) {
                Socket client = server.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    out.println("Echo: " + message);
                }
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}