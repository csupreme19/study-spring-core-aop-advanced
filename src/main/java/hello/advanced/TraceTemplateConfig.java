package hello.advanced;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TraceTemplateConfig {

    private final LogTrace logTrace;

    @Bean
    public TraceTemplate traceTemplate() {
        return new TraceTemplate(logTrace);
    }

}
