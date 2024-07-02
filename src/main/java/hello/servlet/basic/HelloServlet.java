package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// WebServlet annotation -> ?
@WebServlet(name = "helloServlet", urlPatterns = "/hello") // url patterns 요청 url 이 오면 반응 한다는 뜻 mapping

public class HelloServlet extends HttpServlet { //    서블렛 기능을 쓰려면 상속 http servlet 을 상속 받아야 사용이 가능하다
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // service 로직 실행하는 창
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        //        request = org.apache.catalina.connector.RequestFacade@53e4c055
//        response = org.apache.catalina.connector.ResponseFacade@f93484c
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plan");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello"+username);

    }
// soutvm -> 현제 클래스 명 찍기.
}
