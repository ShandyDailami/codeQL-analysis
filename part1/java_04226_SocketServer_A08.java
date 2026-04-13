import java.io.*;
import java.net.*;

public class java_04226_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (inputLine.equals("exit")) {
                    out.println("Bye!");
                    break;
                } else if (inputLine.equals("fail")) {
                    throw new SecurityException("Integrity Failure");
                } else {
                    out.println("Echo: " + inputLine);
                }
            }

            socket.close();
        }
    }
}