package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
/*
* HTTP 요청데이터 -API 메시지 바디 -단순 텍스트*/
@WebServlet(name="requestBodyStringServlet",urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();//http바디의내용을 바이트코드로 바로 얻을수있다
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // 바이트코드를 스트링으로변환
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("OK");
    }
}
