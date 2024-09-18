package br.com.jax.ws.rs.controller.login;

import br.com.jax.ws.rs.controller.login.dto.LoginDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/login")
public class LoginController {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(LoginDTO loginDTO) {
        String token = UUID.randomUUID().toString();
        return "{\"status\": \"success\", \"token\": \"%s\", \"email\": \"%s\"}".formatted(token, loginDTO.getEmail());
    }

}
