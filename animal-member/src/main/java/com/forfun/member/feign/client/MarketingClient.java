package com.forfun.member.feign.client;

import com.forfun.member.feign.fallback.MarketingHystrixFallback;
import com.forfun.member.response.DefaultResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "animal-marketing", fallback = MarketingHystrixFallback.class)
public interface MarketingClient {

    @RequestMapping(value = "/points", method = RequestMethod.GET)
    DefaultResponse<String> findByUserId(@RequestParam("userId") String userId);
}
