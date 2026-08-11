package com.example.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {

    private String messageid;
    private String message;
    private String messageDate;

    public void setMessgaeDate(Date date) {
    }
}
