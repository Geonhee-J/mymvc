package web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class BeanListener implements ServletContextListener {

    public BeanListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("BeanListener Start!");
        // 스프링의 Bean에 해당하는 객체를 Pool(Collection)에 등록
        // web은 Attribute라는 Map타입의 Pool저장공간이 있다

        // 컨텍스트 객체를 구현
        ServletContext context = sce.getServletContext(); // JSP에선 application객체

        // 컨텍스트 객체안에

        // 1) myDao라는 빈을 생성 후 저장
        MyDao myDao = new MyDao(); // 스프링에서는 xml에서 bean태그, @Bean, 클래스위에 @Repository
        context.setAttribute("myDao", myDao);

        // 2) myService라는 빈을 생성 후 저장(앞의 myDao를 주입) // @Autowired
        // 생성자 주입을 사용하는 경우
        // -> MyService myService = new MyService((MyDao) context.getAttribute("myDao"));
        // -> MyService myService = new MyService(myDao);

        // setter 주입을 사용하는 경우
        MyService myService = new MyService();
        myService.setMyDao(myDao); // -> myService.setMyDao((MyDao) context.getAttribute("myDao"));
        context.setAttribute("myService", myService);

        // Hello dao, service 빈
        HelloDao helloDao = new HelloDao();
        context.setAttribute("helloDao", helloDao);

        HelloService helloService = new HelloService();
        helloService.setHelloDao((HelloDao) context.getAttribute("helloDao"));
        context.setAttribute("helloService", helloService);

        // Bye dao, service 빈
        ByeDao byeDao = new ByeDao();
        context.setAttribute("byeDao", byeDao);

        ByeService byeService = new ByeService();
        byeService.setByeDao((ByeDao) context.getAttribute("byeDao"));
        context.setAttribute("byeService", byeService);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }

}
