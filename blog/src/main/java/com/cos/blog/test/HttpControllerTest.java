package com.cos.blog.test;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {
    private static final String TAG = "HttpControllerTest";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m1 = new Member(123, "hihi", 123124, "email@email.com");
        Member m2 = new Member();
        System.out.println(TAG + "getter: " + m1.getId());
        m1.setId(5000);
        System.out.println(TAG + "setter: " + m1.getId());
        return "lombok test";
    }

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청" + ", " + m.getId() + ", " + m.getUsername() + ", " + m.getEmail();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
        return "post 요청" + ", " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
