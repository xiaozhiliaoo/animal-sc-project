package org.lili.forfun.ui;

import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
@EnableRedisHttpSession
public class UiApplication {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/pc/403");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/pc/404");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/pc/500");
            container.addErrorPages(error403Page, error404Page, error500Page);
        });
    }

    @RequestMapping(value = "/testurl/{path}")
    public ModelAndView path(@PathVariable String path) {
        path = path.replaceAll("@", "/");
        return new ModelAndView(path);
    }

//    @Bean
//    public Encoder feignEncoder() {
//        return new PageableEncoder(new SpringEncoder(messageConverters));
//    }
}
