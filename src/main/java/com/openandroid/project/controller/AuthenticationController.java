package com.openandroid.project.controller;

import com.openandroid.project.dto.DtoRegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private static final String SUCCESS = "Success create account, please verify your email";
    private static final String FAILED = "Fail to send confirmation email";

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody DtoRegisterRequest dtoRegisterRequest) {
        try {
            String subject = "Konfirmasi Pendaftaran";
            String text = "Terima kasih atas pendaftaran Anda di pusat kebugaran kami. Berikut Nomor OTP untuk megaktifkan akun Anda:";
            String verificationCode = emailService.sendEmail(dtoRegisterRequest.getEmail(), subject, text);
            registrationService.register(dtoRegisterRequest, verificationCode);
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(FAILED);
        }

        return ResponseEntity.ok(SUCCESS);
    }
}
