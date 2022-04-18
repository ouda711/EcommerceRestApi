package com.ecommerce.restapi.dtos.requests;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.*;

public class RegisterDto implements Serializable {
    @Size(min = 4, max = 255, message = "{errors.first_name.first_name.size}")
    @NotNull(message = "{errors.first_name.first_name.null}")
    @NotEmpty(message = "{errors.first_name.first_name.empty}")
    private final String first_name;

    @Size(min = 4, max = 255, message = "{errors.last_name.last_name.size}")
    @NotNull(message = "{errors.last_name.last_name.null}")
    @NotEmpty(message = "{errors.last_name.last_name.empty}")
    private final String last_name;

    @Email(message = "Email must be valid")
    @NotBlank
    @Size(max = 60)
    private final String email_address;

    @NotEmpty(message = "Phone number is required")
    @Size(min = 8, max = 15)
    private final String phone_number;

    @NotBlank
    @Size(min = 6, max = 40)
    private final String password;

    public RegisterDto(String first_name, String last_name, String email_address, String phone_number, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_address = email_address;
        this.phone_number = phone_number;
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterDto entity = (RegisterDto) o;
        return Objects.equals(this.first_name, entity.first_name) &&
                Objects.equals(this.last_name, entity.last_name) &&
                Objects.equals(this.email_address, entity.email_address) &&
                Objects.equals(this.phone_number, entity.phone_number) &&
                Objects.equals(this.password, entity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, email_address, phone_number, password);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "first_name = " + first_name + ", " +
                "last_name = " + last_name + ", " +
                "email_address = " + email_address + ", " +
                "phone_number = " + phone_number + ", " +
                "password = " + password + ")";
    }
}
