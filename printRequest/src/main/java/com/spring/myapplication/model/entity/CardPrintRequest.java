package com.spring.myapplication.model.entity;

import com.spring.myapplication.model.embeded.CardPrintRequestId;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Hi on 6/6/2022.
 */
@Entity(name ="cardprintrequest")
@Table(name ="t_cardprintrequest")
public class CardPrintRequest implements Serializable {

    @EmbeddedId
    private CardPrintRequestId cardPrintRequestId;

    @Column(columnDefinition = "VARCHAR2(20)",name = "c_cardPan")
    private String cardPan;

    @Column(nullable = false,name = "c_personnelCode")
    @Size(min = 5, max = 10)
    private String personnelCode;

    @Column(nullable = false,name = "c_branchCode")
    @Min(3)
    private String branchCode;

    @Column(columnDefinition = "VARCHAR2(20)",name = "c_ipAddress")
    private String ipAddress;

    public CardPrintRequest() {
    }

    public CardPrintRequest(CardPrintRequestId cardPrintRequestId, String cardPan, @Size(min = 5, max = 10) String personnelCode, @Min(3) String branchCode, String ipAddress) {
        this.cardPrintRequestId = cardPrintRequestId;
        this.cardPan = cardPan;
        this.personnelCode = personnelCode;
        this.branchCode = branchCode;
        this.ipAddress = ipAddress;
    }


    public CardPrintRequest(String cardPan, @Size(min = 5, max = 10) String personnelCode, @Min(3) String branchCode, String ipAddress) {
        this.cardPan = cardPan;
        this.personnelCode = personnelCode;
        this.branchCode = branchCode;
        this.ipAddress = ipAddress;
    }


    public CardPrintRequestId getCardPrintRequestId() {
        return cardPrintRequestId;
    }

    public void setCardPrintRequestId(CardPrintRequestId cardPrintRequestId) {
        this.cardPrintRequestId = cardPrintRequestId;
    }

    public String getCardPan() {
        return cardPan;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
