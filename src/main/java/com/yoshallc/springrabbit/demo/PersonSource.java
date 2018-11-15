package com.yoshallc.springrabbit.demo;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PersonSource {


    String SINGLE_MESSAGE = "single-message";

    @Output(PersonSource.SINGLE_MESSAGE)
    MessageChannel singleGrapeChannel();


}


