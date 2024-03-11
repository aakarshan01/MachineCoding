package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.PaymentInstrumentType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aakarshan.gupta on 11/03/24.
 */
public class Constants {
    // overall constants

    // in any chance something left in filter will be displayed in bottom
    public static final Integer DEFAULT_PAYMENT_SORTER_VALUE = Integer.MAX_VALUE;


    // investment constants
    public static final int UPI_INVESTMENT_LIMIT = 100000;
    public static final int NET_BANKING_INVESTMENT_LIMIT = 150000;
    public static final int DEBIT_CARD_INVESTMENT_LIMIT = 150000;
    public static final Map<PaymentInstrumentType, Integer> INVESTMENT_SORT_ORDER_MAP = new HashMap(){{
        put(PaymentInstrumentType.UPI,1);
        put(PaymentInstrumentType.NETBANKING,2);
        put(PaymentInstrumentType.DEBIT_CARD,3);
    }};


    // commerce constants
    public static final int UPI_COMMERCE_LIMIT = 100000;
    public static final int CREDIT_CARD_COMMERCE_LIMIT = 250000;
    public static final int DEBIT_CARD_COMMERCE_LIMIT = 200000;
    public static final Map<PaymentInstrumentType, Integer> COMMERCE_SORT_ORDER_MAP = new HashMap(){{
        put(PaymentInstrumentType.CREDIT_CARD,1);
        put(PaymentInstrumentType.UPI,2);
        put(PaymentInstrumentType.DEBIT_CARD,3);
    }};

    // credit card bill constants
    public static final int UPI_CREDIT_CARD_BILL_LIMIT = 200000;
    public static final int NET_BANKING_CREDIT_CARD_BILL_LIMIT = 200000;
    public static final int DEBIT_CARD_CREDIT_CARD_BILL_LIMIT = 200000;
    public static final Map<PaymentInstrumentType, Integer> CREDIT_CARD_BILL_SORT_ORDER_MAP = new HashMap(){{
        put(PaymentInstrumentType.UPI,1);
        put(PaymentInstrumentType.NETBANKING,2);
        put(PaymentInstrumentType.DEBIT_CARD,3);
    }};
}
