package com.example.todo_api.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    public void getAllBeanTest() {
        // 스프링 컨테이너를 설정 파일 정보를 이용해서 생성하고, 스프링 컨테이너 안에 잇는 모든 빈을 조회하는 테스트
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        // context 안에 myBean 이 들어있는지 확인
        Assertions.assertThat(context.getBeanDefinitionNames()).contains("myBean");
    }

    @Test
    public void getOneBeanTest() {
        MyBean bean1 = context.getBean(MyBean.class);
        MyBean bean2 = context.getBean(MyBean.class);
//        MyBean bean3 = new MyBean();

        Assertions.assertThat(bean1).isSameAs(bean2);
//        Assertions.assertThat(bean2).isNotEqualTo(bean3);
    }

    @Test
    public void dependencyInjectionTest() {
        MyBean bean = context.getBean(MyBean.class);
        MySubBean subBean1 = bean.getMySubBean();
        MySubBean subBean2 = context.getBean(MySubBean.class);

        Assertions.assertThat(subBean1).isSameAs(subBean2);
    }
}
