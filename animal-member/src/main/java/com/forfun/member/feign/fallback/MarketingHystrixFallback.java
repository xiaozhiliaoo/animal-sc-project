package com.forfun.member.feign.fallback;


import com.forfun.member.feign.client.MarketingClient;
import com.forfun.member.response.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class MarketingHystrixFallback implements MarketingClient {

    private static final Logger LOG = LoggerFactory.getLogger(MarketingHystrixFallback.class);


    @Override
    public DefaultResponse<String> findByUserId(@RequestParam("userId") String userId) {
        DefaultResponse defaultResponse = DefaultResponse.getFailedDefaultResponse();
        return defaultResponse;
    }
}
