package com.packt.blog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(contact = @Contact(name = "Jake TIOKOU", email = "tmelvinjake@gmail.com"), description = "OpenApi documentation for Blog Application", title = "OpenApi specification - Article", version = "1.0"

), servers = {
    @Server(description = "Local ENV", url = "http://localhost:9000"),
})
public class OpenApiConfig {

}
