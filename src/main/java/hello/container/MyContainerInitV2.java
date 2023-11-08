package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(AppInit.class)  // 초기화 인터페이스 지정
public class MyContainerInitV2 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");
        System.out.println("MyContainerInitV2 c = " + c);
        System.out.println("MyContainerInitV2 ctx = " + ctx);

        // 구현체가 있으면
        for (Class<?> clazz : c) {
            try {
                AppInit appInit = (AppInit) clazz.getConstructor().newInstance();
                appInit.onStartup(ctx);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }

    }
}
