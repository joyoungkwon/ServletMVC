package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/*
*  1. parameter 전송 기능
*   url = http://localhost:8080/request-param?username=hello&age=20 
* */

@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 start-----");
        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName +":" + request.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 end-----");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("단일 파라미터 조회");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("age"));
        System.out.println("----------------------------------------");

        System.out.println("이름이 같은 복수 파라미터 조회 하는 방법");
        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
        response.setContentType("text");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("오늘도 열공중");
    }
}
