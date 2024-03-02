package com.openandroid.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @JsonProperty("phone_number")
    @Column(name="phone_number")
    private String phoneNumber;

    @JsonProperty("is_verified")
    @Column(name="is_verified")
    private boolean isVerified;

    @JsonProperty("verification_code")
    @Column(name="verification_code")
    private String verificationCode;

    @JsonProperty("reset_token")
    @Column(name="reset_token")
    private String resetToken;

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public String getResetToken() {
        return resetToken;
    }
}
