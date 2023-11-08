package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        // 스프링 컨테이너 생성
        AnnotationConfigWebApplicationContext annotationConfigApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigApplicationContext.register(HelloConfig.class);

        // 스프링 디스패처 서블릿 생성, 컨테이너 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigApplicationContext);
        servletContext.addServlet("dispatcherServletV2", dispatcherServlet)
                .addMapping("/spring/*");  //이 경로로 들어오면 디스패처 서블릿이 처리하도록 매핑
    }
}
