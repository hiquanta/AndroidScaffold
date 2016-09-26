package com.hiquanta.scaffold;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by hiquanta on 2016/9/26.
 */
@Getter@Setter
public class User {
    private final int userId;
    public User(int userId) {
        this.userId = userId;
    }

    private String coverUrl;
    private String fullName;
    private String email;
    private String description;
    private int followers;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("***** User Details *****\n");
        stringBuilder.append("id=" + this.userId + "\n");
        stringBuilder.append("cover url=" + this.coverUrl + "\n");
        stringBuilder.append("fullname=" + this.fullName + "\n");
        stringBuilder.append("email=" + this.email + "\n");
        stringBuilder.append("description=" + this.description + "\n");
        stringBuilder.append("followers=" + this.followers + "\n");
        stringBuilder.append("*******************************");

        return stringBuilder.toString();
    }
}