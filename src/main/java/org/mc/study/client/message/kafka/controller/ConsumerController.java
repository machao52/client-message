package org.mc.study.client.message.kafka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author machao
 * @date 2020-05-14
 */

@RestController
@RequestMapping("kafka")
public class ConsumerController {


    @RequestMapping
    public void acceptMessage(){

    }


}
