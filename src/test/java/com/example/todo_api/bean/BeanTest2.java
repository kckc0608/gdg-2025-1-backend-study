package com.example.todo_api.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest2 {

    @Autowired
    private MyBean myBean;

    @Autowired
    private MySubBean mySubBean;

    @Test
    public void dependencyInjectionTest() {
        MySubBean subBean1 = myBean.getMySubBean();

        Assertions.assertThat(subBean1).isSameAs(mySubBean);
    }
}
