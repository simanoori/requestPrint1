package com.spring.myapplication.repository.custom;

import java.util.List;

/**
 * Created by Hi on 6/11/2022.
 */
public interface CardPrintRequestCustom {
    List<String> getIpAddressesByBranchCode(String branchCode);

}
