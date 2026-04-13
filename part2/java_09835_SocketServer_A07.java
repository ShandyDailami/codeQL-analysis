import java.io.*;
import java.net.*;
import java.util.*;

public class java_09835_SocketServer_A07 {
    private static final String AUTH_FAILURE_PREFIX = "A07_AuthFailure: ";
    private static final String AUTH_FAILURE_SUFFIX = " End";

    private static class LegacySocketThread extends Thread {
        private Socket socket;

        public java_09835_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    out.println(processInput(inputLine));
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String processInput(String input) {
            if (isAuthenticationFailure(input)) {
                return AUTH_FAILURE_PREFIX + input + AUTH_FAILURE_SUFFIX;
            }
            return input;
        }

        private boolean isAuthenticationFailure(String input) {
            return input.startsWith(AUTH_FAILURE_PREFIX) && input.endsWith(AUTH_FAILURE_SUFFIX);
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            Socket socket = serverSocket.accept();
            LegacySocketThread thread = new LegacySocketThread(socket);
            thread.start();
        }
    }
}