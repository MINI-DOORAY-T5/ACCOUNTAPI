package com.nhnacademy.minidooray.accountapi;

public enum Status {
    active("가입"),
    dormant("휴먼"),
    closed("탈퇴");

    private final String statu;

    private Status(String statu) {
        this.statu = statu;
    }

    public String getStirng() {
        return statu;
    }


}
