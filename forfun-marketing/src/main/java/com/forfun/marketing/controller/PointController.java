package com.forfun.marketing.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PointController {

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    public String findByUserId(@RequestParam("userId") String userId) {
        return null;
    }
}
