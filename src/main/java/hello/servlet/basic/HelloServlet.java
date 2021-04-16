package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override //서블릿이 호출되면 이 서비스메서드가 호출된다
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username =  request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");//헤더부분에들어감
        response.setCharacterEncoding("utf-8");//헤더부분에들어감
        response.getWriter().write("hello " + username);//바디 부분에 들어감

    }
}
