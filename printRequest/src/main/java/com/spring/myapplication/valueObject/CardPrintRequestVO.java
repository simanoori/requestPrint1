package com.spring.myapplication.valueObject;

import com.spring.myapplication.model.embeded.CardPrintRequestId;
import com.spring.myapplication.model.entity.CardPrintRequest;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by Hi on 6/18/2022.
 */
public class CardPrintRequestVO {

    private CardPrintRequestId cardPrintRequestId;
    private String cardPan;
    private String personnelCode;
    private String branchCode;
    private String ipAddress;

    public CardPrintRequestId getCardPrintRequestId() {
        return cardPrintRequestId;
    }

    public static CardPrintRequestVO cloneFromDB(CardPrintRequest cardPrintRequest){
        CardPrintRequestVO cardPrintRequestVO = new CardPrintRequestVO();
        cardPrintRequestVO.setBranchCode(cardPrintRequest.getBranchCode());
        cardPrintRequestVO.setCardPan(cardPrintRequest.getCardPan());
        cardPrintRequestVO.setIpAddress(cardPrintRequest.getIpAddress());
        cardPrintRequestVO.setPersonnelCode(cardPrintRequest.getPersonnelCode());
        return cardPrintRequestVO;
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
