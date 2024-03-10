package com.openandroid.project.service;

import com.openandroid.project.dto.DtoRegisterRequest;
import com.openandroid.project.model.Developer;
import com.openandroid.project.repository.IAuthTokenRepository;
import com.openandroid.project.repository.IDeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

@Service
public class RegistrationService {
    @Autowired
    private IAuthTokenRepository authTokenRepository;
    @Autowired
    private IDeveloperRepository developerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String register(DtoRegisterRequest request, String verificationCode) throws MessagingException {

        if (developerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email sudah digunakan.");
        }

        Developer developer = new Developer();
        developer.setName(request.getName());
        participant.setEmail(request.getEmail());
        participant.setPassword(passwordEncoder.encode(request.getPassword()));
        participant.setPhoneNumber(request.getPhoneNumber());
        participant.setVerified(false);
        participant.setVerificationCode(verificationCode);

        String creditCardInfo = encryptCreditCardInfo(request.getCreditCard().getCardNo() +
                request.getCreditCard().getCvv() +
                request.getCreditCard().getExpiredDate() +
                request.getCreditCard().getOwnerName());

        participant.setCreditCardInfo(creditCardInfo);

        developerRepository.save(developer);

        return verificationCode;
    }
}
