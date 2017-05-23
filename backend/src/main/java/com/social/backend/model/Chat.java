package com.social.backend.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="C_Chat")
public class Chat extends ErrorPage {

}
