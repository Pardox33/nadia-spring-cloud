package com.nadia.message.functions;

import com.nadia.message.dto.EmployeMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<EmployeMessageDto, EmployeMessageDto> email() {
        return employeMsgDto -> {
            log.info("Sending email with the details : " + employeMsgDto.toString());
            return employeMsgDto;
        };
    }

    @Bean
    public Function<EmployeMessageDto, Long> sms() {
        return employeMsgDto -> {
            log.info("Sending sms with the details : " + employeMsgDto.toString());
            return employeMsgDto.employeId();
        };
    }
}