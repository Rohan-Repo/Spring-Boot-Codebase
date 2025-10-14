package in.easysystems.create_fake_data.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class WebConfig {
    @Bean
    Faker faker() {
        return new Faker( new Locale("en-CA") );
    }
}
