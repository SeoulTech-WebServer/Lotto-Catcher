package seoultech.webserver.lotto.config.feign;


import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seoultech.webserver.lotto.config.interceptor.FeignInterceptor;

@Configuration
public class FeignConfig {

    @Bean
    public Feign.Builder tcsClientBuilder() {
        return Feign.builder().requestInterceptor(new FeignInterceptor());
    }
}
