package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class McvMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath="/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);//컨트롤러에서 뷰로이동할때
        dispatcher.forward(request,response);//서블릿에서 JSP 호출(서버끼리 내부에서 호출)
    }
}
