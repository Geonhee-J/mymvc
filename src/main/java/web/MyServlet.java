package web;

import java.io.IOException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    MyService myService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/요청 -> MyServlet 호출");

        // DI: BeanListeneer에서 등록한 객체를 사용
        ServletContext context = request.getServletContext();
        myService = (MyService) context.getAttribute("myService");
        System.out.println(myService.getModel());
    }
}
