package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.PaymentInstrument;

import static com.paymentrecommendation.service.Constants.*;

/**
 * Created by aakarshan.gupta on 11/03/24.
 */
public class SortersForInstrumentTypes {
    public static int sorterPaymentInstrumentTypesForInvestment(PaymentInstrument paymentInstrument1, PaymentInstrument paymentInstrument2) {
        PaymentInstrumentType paymentInstrumentType1 = paymentInstrument1.getPaymentInstrumentType();
        PaymentInstrumentType paymentInstrumentType2 = paymentInstrument2.getPaymentInstrumentType();

        if(paymentInstrumentType1.equals(paymentInstrumentType2)){
            if(paymentInstrument1.getRelevanceScore()<paymentInstrument2.getRelevanceScore())
                return 1;
            else
                return -1;
        }
        else{
            return INVESTMENT_SORT_ORDER_MAP.getOrDefault(paymentInstrumentType1, DEFAULT_PAYMENT_SORTER_VALUE) - INVESTMENT_SORT_ORDER_MAP.getOrDefault(paymentInstrumentType2, DEFAULT_PAYMENT_SORTER_VALUE);
        }
    }

    public static int sorterPaymentInstrumentTypesForCommerce(PaymentInstrument paymentInstrument1, PaymentInstrument paymentInstrument2) {
        PaymentInstrumentType paymentInstrumentType1 = paymentInstrument1.getPaymentInstrumentType();
        PaymentInstrumentType paymentInstrumentType2 = paymentInstrument2.getPaymentInstrumentType();

        if(paymentInstrumentType1.equals(paymentInstrumentType2)){
            if(paymentInstrument1.getRelevanceScore()<paymentInstrument2.getRelevanceScore())
                return 1;
            else
                return -1;
        }
        else{
            return COMMERCE_SORT_ORDER_MAP.getOrDefault(paymentInstrumentType1, DEFAULT_PAYMENT_SORTER_VALUE) - COMMERCE_SORT_ORDER_MAP.getOrDefault(paymentInstrumentType2, DEFAULT_PAYMENT_SORTER_VALUE);
        }
    }

    public static int sorterPaymentInstrumentTypesForCreditCardBill(PaymentInstrument paymentInstrument1, PaymentInstrument paymentInstrument2) {
        PaymentInstrumentType paymentInstrumentType1 = paymentInstrument1.getPaymentInstrumentType();
        PaymentInstrumentType paymentInstrumentType2 = paymentInstrument2.getPaymentInstrumentType();

        if(paymentInstrumentType1.equals(paymentInstrumentType2)){
            if(paymentInstrument1.getRelevanceScore()<paymentInstrument2.getRelevanceScore())
                return 1;
            else
                return -1;
        }
        else{
            return CREDIT_CARD_BILL_SORT_ORDER_MAP.getOrDefault(paymentInstrumentType1, DEFAULT_PAYMENT_SORTER_VALUE) - CREDIT_CARD_BILL_SORT_ORDER_MAP.getOrDefault(paymentInstrumentType2, DEFAULT_PAYMENT_SORTER_VALUE);
        }
    }
}
