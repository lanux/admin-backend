package com.lx.web.sys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sys/user")
public class SysUserController {

    @RequestMapping("/list")
    @ResponseBody
    public String list() {
        return "hello";
    }
}
