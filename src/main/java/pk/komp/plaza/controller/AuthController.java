package pk.komp.plaza.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pk.komp.plaza.model.dto.LoginDto;
import pk.komp.plaza.model.entity.User;
import pk.komp.plaza.repository.UserRepository;

import java.util.logging.LogRecord;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {

        User user = userRepository.findByUsername(loginDto.getUsername());
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        if(!user.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password");
        }
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        System.out.println(SecurityContextHolder.getContext().getAuthentication().toString());

        return ResponseEntity.ok("Login successful!");
    }


}
