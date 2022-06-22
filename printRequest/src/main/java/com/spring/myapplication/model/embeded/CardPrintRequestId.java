package com.spring.myapplication.model.embeded;

import java.io.Serializable;

/**
 * Created by Hi on 6/6/2022.
 */
public class CardPrintRequestId implements Serializable{
    private String branchCode;
    private String ipAddress;

    public CardPrintRequestId(String branchCode, String ipAddress) {
        this.branchCode = branchCode;
        this.ipAddress = ipAddress;
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
