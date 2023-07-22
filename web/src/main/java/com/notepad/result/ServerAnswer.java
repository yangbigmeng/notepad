package com.notepad.result;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by YM on 2017/6/11.
 */
public class ServerAnswer<T> {

    public ServerAnswer (int status, String message, T reponse) {
        this.status = status;
        this.message = message;
        this.reponse = reponse;
    }

    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("cost_time")
    private long costTime;

    @JsonProperty("response")
    private T reponse;

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }
}
