package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public class Lesson extends BaseEntity{

    protected int capacityMax;
    protected LocalDateTime dateTimeStart;
    protected LocalDateTime dateTimeEnd;

}
