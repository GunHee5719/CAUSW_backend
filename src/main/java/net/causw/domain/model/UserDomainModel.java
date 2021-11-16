package net.causw.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDomainModel {
    private String id;
    private String studentId;
    private String profileImage;

    @NotBlank(message = "Name is blank")
    private String name;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email is null")
    private String email;

    @NotBlank(message = "Password is blank")
    private String password;

    @NotNull(message = "Admission Year is null")
    private Integer admissionYear;

    @NotNull(message = "Role is null")
    private Role role;

    @NotNull(message = "User State is null")
    private UserState state;

    private UserDomainModel(
            String id,
            String email,
            String name,
            String password,
            String studentId,
            Integer admissionYear,
            Role role,
            String profileImage,
            UserState state
    ) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.studentId = studentId;
        this.admissionYear = admissionYear;
        this.role = role;
        this.profileImage = profileImage;
        this.state = state;
    }

    public static UserDomainModel of(
            String id,
            String email,
            String name,
            String password,
            String studentId,
            Integer admissionYear,
            Role role,
            String profileImage,
            UserState state
    ) {
        return new UserDomainModel(
                id,
                email,
                name,
                password,
                studentId,
                admissionYear,
                role,
                profileImage,
                state
        );
    }

    public static UserDomainModel of(
            String email,
            String name,
            String password,
            String studentId,
            Integer admissionYear,
            String profileImage
    ) {
        // TODO : Remove following -> Default로 Role.NONE 지정
        Role localRole = Role.NONE;
        UserState localUserState = UserState.AWAIT;
        if (email.equals("admin@gmail.com")) {
            localRole = Role.ADMIN;
            localUserState = UserState.ACTIVE;
        }

        return new UserDomainModel(
                null,
                email,
                name,
                password,
                studentId,
                admissionYear,
                localRole,
                profileImage,
                localUserState
        );
    }
}
