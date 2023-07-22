package com.notepad.service;

import com.notepad.model.Answer;
import com.notepad.model.Question;
import org.springframework.stereotype.Service;

/**
 * Created by YM on 2017/6/11.
 */
@Service
public class ServiceEngineImpl implements ServiceEngine{

    @Override
    public Answer process(Question question) {
        Answer answer = new Answer();
        if (NAME.equals(question.getName())) {
            answer.setName(NAME);
            answer.setAge(AGE);
            answer.setAddress(ADDRESS);
        } else {
            answer.setName(question.getName());
            answer.setAge(DEFAULT);
            answer.setAddress(DEFAULT);
        }
        return answer;
    }

    private static final String NAME = "yangmeng";
    private static final String AGE = "27";
    private static final String ADDRESS = "CHINA";
    private static final String DEFAULT = "not find";
}
