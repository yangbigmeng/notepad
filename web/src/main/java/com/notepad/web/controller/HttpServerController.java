package com.notepad.web.controller;

import com.notepad.web.request.Query;
import com.notepad.web.result.AnswerBuilder;
import com.notepad.web.result.ServerAnswer;
import com.notepad.model.Answer;
import com.notepad.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notepad.service.ServiceEngine;
import com.notepad.util.JsonUtils;

import javax.validation.Valid;

/**
 * Created by YM on 2017/6/4.
 */
@RestController
public class HttpServerController {

    @Autowired
    private ServiceEngine serviceEngine;

    private static final Logger LOG = LoggerFactory.getLogger(HttpServerController.class);

    @RequestMapping("/httpserver/")
    public String httpServer(@Valid Query query, Errors errors){
        try {
            Question question = query.convertToQuery();
            Answer answer = serviceEngine.process(question);
            ServerAnswer<Answer> result = AnswerBuilder.buildSuccess(answer);
            return JsonUtils.serialize(result);
        } catch (Exception e) {
            e.printStackTrace();
            ServerAnswer<Answer> result = AnswerBuilder.buildFailed(null, e.getMessage());
            return JsonUtils.serialize(result);
        }
    }
}
