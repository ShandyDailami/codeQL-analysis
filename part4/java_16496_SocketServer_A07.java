import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;

public class java_16496_SocketServer_A07 {
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();

            // Create a new process for each connection
            Process process = Runtime.getRuntime().exec("echo " + socket.getInetAddress() + " > /dev/null");
            process.waitFor();

            // Send a message to the child process
            process.getOutputStream().write((random.nextInt() + " " + "Hello, World!").getBytes());
            process.getOutputStream().close();
        }
    }
}