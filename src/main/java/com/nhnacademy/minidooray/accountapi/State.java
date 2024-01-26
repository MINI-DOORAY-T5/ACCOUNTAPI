package com.nhnacademy.minidooray.accountapi;

public enum State {
    active("가입"),
    dormant("휴먼"),
    closed("탈퇴");

    private final String state;

    private State(String state) {
        this.state = state;
    }

    public String getStirng() {
        return state;
    }


}
