package com.scheduler.payload;

public class UserDto {
    private String name;
    private String mobile;

    public void setName(String name) {
        this.name = name;
    }

    public void settMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
