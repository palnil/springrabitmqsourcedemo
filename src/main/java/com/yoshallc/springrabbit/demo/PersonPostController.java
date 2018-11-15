package com.yoshallc.springrabbit.demo;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonPostController {

    private PersonSource personSource;

    public PersonPostController(PersonSource personSource){

        this.personSource = personSource;
    }

    @PostMapping("/post")
    public void postMessage(@RequestBody Data info){

            personSource.singleGrapeChannel().send(MessageBuilder.withPayload(info).build());

    }

}
