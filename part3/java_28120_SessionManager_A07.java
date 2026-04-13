public class java_28120_SessionManager_A07 implements SessionManager {
    private boolean isAuthorized = true;

    public java_28120_SessionManager_A07() {
        // Load user info from somewhere or set default user
    }

    public void beginSession() {
        // No-op, we're not tracking sessions in this case
    }

    public Session getSession() {
        if (!isAuthorized) {
            throw new AuthFailureException("User not authorized");
        }

        return new Session() {
            @Override
            public void setAttribute(String s, Object o) {
                // No-op
            }

            @Override
            public Object getAttribute(String s) {
                // No-op
                return null;
            }

            @Override
            public void invalidate() {
                // No-op
            }
        };
    }

    public void endSession(Session session) {
        // No-op
    }

    public void authFailure(FailureMode failureMode, String s) {
        if (failureMode == FailureMode.ACCESS_DENIED_PAGE) {
            isAuthorized = false;
        }
    }
}