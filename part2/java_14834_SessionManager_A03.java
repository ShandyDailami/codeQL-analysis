public class java_14834_SessionManager_A03 {
    private Injectable injectable;

    public java_14834_SessionManager_A03(Injectable injectable) {
        this.injectable = injectable;
    }

    public void doSomething() {
        // Simulate injecting the injectable bean into the session.
        injectable.doSomething();
    }
}

public interface Injectable {
    void doSomething();
}

public class InjectableBean implements Injectable {

    @Override
    public void doSomething() {
        System.out.println("Injectable bean is doing something...");
    }
}

public class Main {
    public static void main(String[] args) {
        Injectable injectable = new InjectableBean();
        SessionManager sessionManager = new SessionManager(injectable);
        sessionManager.doSomething();
    }
}