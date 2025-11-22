package in.easysystems.showcastdb.config;


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
        server.setDescription( "REST CRUD Dev Server" );

        Contact userDetails = new Contact();
        userDetails.setName( "Ms. Chanandler Bong" );
        userDetails.setEmail( "ms.chanandler.bong@friends.com" );

        Info info = new Info()
                .description( "A REST API for streamlined management(CRUD) of TV show cast and actor information." )
                .title( "ShowCastDB CRUD REST API" )
                .version( "1.0" )
                .contact( userDetails );

        return  new OpenAPI().info( info ).servers(List.of(server) );
    }
}
