package com.example.onlineproductstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.onlineproductstore.dto.user.UserLoginRequestDto;
import com.example.onlineproductstore.dto.user.UserLoginResponseDto;
import com.example.onlineproductstore.model.User;
import com.example.onlineproductstore.security.JwtUtil;
import com.example.onlineproductstore.service.impl.AuthenticationServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest {
    private static User user;
    private static UserLoginRequestDto userLoginRequestDto;
    @Mock
    private JwtUtil jwtUtil;
    @Mock
    private AuthenticationManager authenticationManager;
    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeAll
    static void beforeAll() {
        userLoginRequestDto = new UserLoginRequestDto();
        userLoginRequestDto.setPassword("password");
        userLoginRequestDto.setEmail("email");
        user = new User().setFirstName("John").setLastName("Doe").setEmail("johndoe@example.com")
                .setPassword("password123").setShippingAddress("123 Main St");
    }

    @Test
    public void authenticate_validUser_returnsUser() {
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(
                UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(authentication.getName()).thenReturn(user.getEmail());
        String expected = "test token";
        when(jwtUtil.generateToken(anyString())).thenReturn(expected);
        assertEquals(new UserLoginResponseDto(expected),
                authenticationService.authenticate(userLoginRequestDto));
    }
}
