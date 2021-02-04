import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import jdk.jfr.Timestamp;


public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String html = null;

        if("admin".equals(name) && "123".equals(password))
            html = "<div style='color:green'>success</div>";
        else
            html = "<div style='color:red'>fail</div>";
        
        PrintWriter pw = resp.getWriter();
        pw.println(html);
    }

    
    
}
