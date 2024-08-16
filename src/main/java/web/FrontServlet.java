package web;

import java.io.IOException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontServlet extends HttpServlet {

    HelloService helloService;
    ByeService byeService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("프론트 서블릿 실행");

        // 모든 요청에 대해서 분기, 잘못된 요청 분기...
        // /hello -> helloService, /bye -> byeService, else -> error

        System.out.println(request.getRequestURI());
        ServletContext context = request.getServletContext();
        String contextPath = request.getContextPath();

        if (request.getRequestURI().equals(contextPath + "/hello")) {
            // /mymvc/hello 요청
            HelloService helloService = (HelloService) context.getAttribute("helloService");
            System.out.println(helloService.getHello());
        } else if (request.getRequestURI().equals(contextPath + "/bye")) {
            // /mymvc/bye 요청
            ByeService byeService = (ByeService) context.getAttribute("byeService");
            System.out.println(byeService.getBye());
        } else if (request.getRequestURI().equals(contextPath)) {
            // /mymvc/ 요청
        } else {
            System.out.println("잘못된 요청 404페이지로 리다이렉트...");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 프론트 서블릿이 POST, GET 두 요청 모두를 처리하기 위해서 POST 요청이 오면 doGet()으로 위임
        doGet(request, response);
    }

}
