package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiAndIoC {

    @Autowired  // 이 클래스(DiAndIoc)가 생성될 때 컨테이너에서 존재하는 C클래스를 생성
    private C c;

    @Autowired
    @Qualifier("ts")
    private TestService testService1;

    @Autowired
    @Qualifier("newTestServiceImpl")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        // A가 B를 의존하는 관계(A에 있는 aCall()을 실행하기 위해서는 b가 필요하기때문)
        // 결합도는 낮은 상태
        B b = new B();
        A a = new A(b);
        a.aCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startedTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }
        return null;
    }
}