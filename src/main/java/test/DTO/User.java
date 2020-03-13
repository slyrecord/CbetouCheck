package test.DTO;

import test.DTO.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
    private Integer userId;
    private String userName;
    private LocalDate birthDate;
    private Gender userGender;

    public User() {

    }

    public User(Integer userId, String userName, LocalDate birthDate, Gender userGender) {
        this.userId = userId;
        this.userName = userName;
        this.birthDate = birthDate;
        this.userGender = userGender;
    }

    public String getUserGender() {
        return this.userGender.name();
    }

    public void setUserGender(String userGender) {
        this.userGender = Gender.valueOf(userGender);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + userName
                + ", date of birth=" + birthDate + ", gender=" + userGender + "]";
    }
}
