package com.notepad.service;

import com.notepad.model.Answer;
import com.notepad.model.Question;

/**
 * Created by YM on 2017/6/11.
 */
public interface ServiceEngine {

    Answer process(Question question);
}
