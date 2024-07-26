package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

    // D 객체가 IoC Container에 없으면 코드를 실행하지 않음
    @Autowired(required = false)
    private D d;

    public void cCall() {
        System.out.println("d: " + d);
        System.out.println("C 객체에서 메소드 호출");
//        d.dCall();
    }
}
