package com.spring.myapplication.model.entity;

import com.spring.myapplication.properties.ApplicationType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Hi on 6/18/2022.
 */
@Entity
@Table
public class ActivityLog {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "c_date")
    private Date date;

    @Column(nullable = false,name = "c_name")
    private String name;

    @Column(nullable = false,name = "c_personalcode")
    private String personalCode;

    @Column(nullable = false,name = "c_cardpan")
    private String cardPAN;

    @Column(nullable = false,name = "c_applicationtype")
    private String applicationType;

    public ActivityLog(String name, String personalCode, String cardPAN) {
        this.name = name;
        this.personalCode = personalCode;
        this.cardPAN = cardPAN;
        this.applicationType = ApplicationType.applicationType;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getCardPAN() {
        return cardPAN;
    }

    public void setCardPAN(String cardPAN) {
        this.cardPAN = cardPAN;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
}
