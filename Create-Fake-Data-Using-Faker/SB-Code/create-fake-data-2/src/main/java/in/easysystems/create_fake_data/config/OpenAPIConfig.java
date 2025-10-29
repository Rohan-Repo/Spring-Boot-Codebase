package in.easysystems.create_fake_data.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI defineAPIConfig(){
        Server server = new Server();
        server.setUrl( "http://localhost:8080" );
        server.setDescription( "Dev Server" );

        Contact userDetails = new Contact();
        userDetails.setName( "Chandler Bing" );
        userDetails.setEmail( "chandler.bing@friends.com" );

        Info info = new Info()
                .description( "Create Fake Data using the Faker Library")
                .title( "Fake Data Creator" )
                .version( "1.0" )
                .contact( userDetails );

        return  new OpenAPI().info( info ).servers(List.of(server) );
    }
}
