package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        //[response-headers]
       // response.setHeader("Content-Type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //캐쉬완전무효화
        response.setHeader("Pragma","no-cache");//과거버전까지 캐쉬를 없애겟다
        response.setHeader("my-header","hello");

        //[Header 편의 메서드]
        //content(response);

        //[Cookie] 편의메서드
        //Cookie(response);

        //[redirect]편의 메서드
        redirect(response);

        //[message body]
        PrintWriter printWriter = response.getWriter();
        printWriter.println("ok");
    }

     //Hedder편의 메서드
     private void content(HttpServletResponse response){
         //Content-Type:text/plain:charset=utf-8   이런모양 으로출력
         //Content-Length:2  이런모양 으로출력

         //response.setHeader("Content-Type","text/plain;charset-utf-8");
         
         /*위주석 1가지를 편하게 사용*/
         response.setContentType("text/plain");
         response.setCharacterEncoding("utf-8");
         //response.setContentLength(2);//생략시 자동생성
    }

    private void Cookie(HttpServletResponse response){
        //Set-Cookie:myCookie=good; Max-Age=600; 이런모양 으로출력

        //response.setHeader("Set-Cookie","myCookie=good;,Max-Age=600");
        
        /*위 두개주석을 간단히 아래방식으로*/
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException{
        //Status Code 302 이런모양 으로출력
        //Location:/basic/hello-form.html 이런모양 으로출력

        //response.setStatus(HttpServletResponse.SC_FOUND); //302 신호
        //response.setHeader("Location","/basic/hello-form.html");

        /*
        * 위 두개 주석을 아래로 간단히 */
        response.sendRedirect("/basic/hello-form.html");
    }
}
