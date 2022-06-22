package com.spring.myapplication.controller;

import com.spring.myapplication.model.entity.CardPrintRequest;
import com.spring.myapplication.service.CardPrintRequestService;
import com.spring.myapplication.valueObject.CardPrintRequestVO;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Hi on 6/20/2022.
 */
@ServletComponentScan("/showcardprintrequest.do")
public class ShowCardPrintRequest extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CardPrintRequestService cardPrintRequestService = new CardPrintRequestService();
            List<CardPrintRequest> cardPrintRequests = cardPrintRequestService.loadCardPrintRequests();
            CardPrintRequest printRequest = null;
            for (CardPrintRequest cardPrintRequest:cardPrintRequests) {
                if(cardPrintRequest.getCardPan().equals(req.getParameter("cardPan")))
                  printRequest = cardPrintRequest;
            }
            CardPrintRequestVO cardPrintRequestVO = CardPrintRequestVO.cloneFromDB(printRequest);
            req.setAttribute("cardprintrequest",cardPrintRequestVO);
            req.getRequestDispatcher("/showCardPrintRequest.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
