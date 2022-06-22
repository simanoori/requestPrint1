package com.spring.myapplication.controller;

import com.spring.myapplication.exception.NotFoundException;
import com.spring.myapplication.valueObject.CardPrintRequestVO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Hi on 6/20/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardPrintRequestControllerTest {

    @MockBean
    private CardPrintRequestController cardPrintRequestController;

    @MockBean
    private CardPrintRequestVO cardPrintRequestVO;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_card_print_request_is_not_found_then_throw_not_fount_exception() {

        Mockito.when(cardPrintRequestVO.getBranchCode()).thenReturn(null);
        Mockito.when(cardPrintRequestVO.getCardPan()).thenReturn(null);
        Mockito.when(cardPrintRequestVO.getIpAddress()).thenReturn(null);
        Mockito.when(cardPrintRequestVO.getPersonnelCode()).thenReturn(null);
        Mockito.when(cardPrintRequestVO.getCardPrintRequestId()).thenReturn(null);

        assertEquals(cardPrintRequestController.saveResource(cardPrintRequestVO),new NotFoundException("card PrintRequest Not Found"));
    }

}