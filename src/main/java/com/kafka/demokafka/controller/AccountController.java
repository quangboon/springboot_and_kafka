package com.kafka.demokafka.controller;

import com.kafka.demokafka.model.AccountDto;
import com.kafka.demokafka.model.MessageDto;
import com.kafka.demokafka.model.StatisticDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController()
@RequestMapping("account")
public class AccountController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/new")
    public AccountDto create(@RequestBody AccountDto account){
        StatisticDto statisticDto = new StatisticDto("Account "+ account.getName() + "is create ", new Date());

        //send notification
        MessageDto messageDto = new MessageDto();
        messageDto.setTo(account.getEmail());
        messageDto.setToName(account.getName());

        messageDto.setSubject("Welcome  to QuangBoon");
        messageDto.setContent("QuangBoon is badboy");
        kafkaTemplate.send("notification", messageDto);

        kafkaTemplate.send("statistic", statisticDto);

        return account;
    }
}
