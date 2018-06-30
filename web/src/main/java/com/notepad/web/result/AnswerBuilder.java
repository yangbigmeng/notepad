package com.notepad.web.result;

/**
 * Created by YM on 2017/6/11.
 */
public class AnswerBuilder {

    public static <T> ServerAnswer<T> buildSuccess(T response) {
        return new ServerAnswer(0, "ok", response);
    }

    public static <T> ServerAnswer<T> buildFailed(T response, String message) {
        return new ServerAnswer(-1, message, response);
    }
}
