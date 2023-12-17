package top.xingzhexiaohui.jointqueryupdaterbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 允许跨域的路径
                // 这里的 url 必须和实际的完全一样，如果是 127.0.0.1 就不能写成 localhost！
                .allowedOrigins("http://localhost:8081") // 允许跨域请求的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的请求方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true) // 是否允许证书（cookies）
                .maxAge(3600); // 预检请求的缓存时间（秒）
    }

    // 如果您需要其他bean的配置，可以继续添加@Bean方法
}
