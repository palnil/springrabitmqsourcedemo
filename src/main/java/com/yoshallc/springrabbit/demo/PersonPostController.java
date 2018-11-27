package com.yoshallc.springrabbit.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonPostController {

    private PersonSource personSource;


    public PersonPostController(PersonSource personSource){

        this.personSource = personSource;

    }

    @PostMapping("/post")
    public void postMessage(@RequestBody Data info){

        personSource.userMessageChannel().send(MessageBuilder.withPayload(info).build());

    }



}
