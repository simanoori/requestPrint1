package com.spring.myapplication.service;

import com.spring.myapplication.aspect.ExecuteTime;
import com.spring.myapplication.model.embeded.CardPrintRequestId;
import com.spring.myapplication.model.entity.CardPrintRequest;
import com.spring.myapplication.repository.jdbc.CardPrintRequestCRUDJDBC;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Hi on 6/13/2022.
 */
@Service
public class CardPrintRequestService {

    CardPrintRequestCRUDJDBC cardPrintRequestCRUDJDBC;

    @ExecuteTime
    @Transactional
    public CardPrintRequest insertCardPrintRequest(CardPrintRequest cardPrintRequest){
        CardPrintRequest saveCardPrintRequest= cardPrintRequestCRUDJDBC.saveCardPrintRequest(cardPrintRequest);
        return saveCardPrintRequest;
    }

    @ExecuteTime
    public CardPrintRequest loadCardPrintRequest(CardPrintRequestId cardPrintRequestId) {
        CardPrintRequest cardPrintRequest= cardPrintRequestCRUDJDBC.loadCardPrintRequest(cardPrintRequestId);
        return cardPrintRequest;
    }

    @ExecuteTime
    public List<CardPrintRequest> loadCardPrintRequests( ) {
        return cardPrintRequestCRUDJDBC.loadCardPrintRequests();

    }


    @ExecuteTime
    @Transactional
    public void updatePersonelCode(CardPrintRequest cardPrintRequest,CardPrintRequestId id){
        cardPrintRequestCRUDJDBC.updatePersonelCode(cardPrintRequest, id);
    }

    @ExecuteTime
    @Transactional
    public void updateCardPan(String cardPan,CardPrintRequest cardPrintRequest){
        cardPrintRequestCRUDJDBC.updateCardPan(cardPan,cardPrintRequest);
    }

}
