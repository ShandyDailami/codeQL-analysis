import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.RowSetResult;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.SinglePassRowSet;

public class java_11684_SessionManager_A03 {

    private SinglePassRowSet rowSet;

    public java_11684_SessionManager_A03() {
        rowSet = RowSetProvider.newInstance().getRowSet();
    }

    public HttpSession createSession(HttpServletRequest request) {
        rowSet.addRow(new SessionRow(request));
        return new HttpSession(rowSet);
    }

    public void destroySession(HttpSession session) {
        ((HttpSessionRow) session).getRowSet().removeRow(session);
    }

    public class SessionRow implements javax.sql.rowset.Row {

        private HttpServletRequest request;

        public java_11684_SessionManager_A03(HttpServletRequest request) {
            this.request = request;
        }

        // implement necessary methods

    }

}