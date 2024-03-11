package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.PaymentInstrumentType;
import com.paymentrecommendation.models.PaymentInstrument;

import static com.paymentrecommendation.service.Constants.*;

/**
 * Created by aakarshan.gupta on 11/03/24.
 */
public class FiltersForInstrumentTypes {

    public static boolean filterPaymentInstrumentTypesForInvestment(PaymentInstrument paymentInstrument, Double cartAmount, boolean upiEnabled) {
        PaymentInstrumentType paymentInstrumentType = paymentInstrument.getPaymentInstrumentType();

        if(paymentInstrumentType.equals(PaymentInstrumentType.UPI) && cartAmount <= UPI_INVESTMENT_LIMIT && upiEnabled){
            return true;
        }
        else if(paymentInstrumentType.equals(PaymentInstrumentType.NETBANKING) && cartAmount <= NET_BANKING_INVESTMENT_LIMIT){
            return true;
        }
        else if(paymentInstrumentType.equals(PaymentInstrumentType.DEBIT_CARD) && cartAmount <= DEBIT_CARD_INVESTMENT_LIMIT){
            return true;
        }
        return false;
    }

    public static boolean filterPaymentInstrumentTypesForCommerce(PaymentInstrument paymentInstrument, Double cartAmount, boolean upiEnabled) {
        PaymentInstrumentType paymentInstrumentType = paymentInstrument.getPaymentInstrumentType();

        if(paymentInstrumentType.equals(PaymentInstrumentType.UPI) && cartAmount <= UPI_COMMERCE_LIMIT && upiEnabled){
            return true;
        }
        else if(paymentInstrumentType.equals(PaymentInstrumentType.CREDIT_CARD) && cartAmount <= CREDIT_CARD_COMMERCE_LIMIT){
            return true;
        }
        else if(paymentInstrumentType.equals(PaymentInstrumentType.DEBIT_CARD) && cartAmount <= DEBIT_CARD_COMMERCE_LIMIT){
            return true;
        }
        return false;
    }

    public static boolean filterPaymentInstrumentTypesForCreditCardBill(PaymentInstrument paymentInstrument, Double cartAmount, boolean upiEnabled) {
        PaymentInstrumentType paymentInstrumentType = paymentInstrument.getPaymentInstrumentType();

        if(paymentInstrumentType.equals(PaymentInstrumentType.UPI) && cartAmount <= UPI_COMMERCE_LIMIT && upiEnabled){
            return true;
        }
        else if(paymentInstrumentType.equals(PaymentInstrumentType.NETBANKING) && cartAmount <= NET_BANKING_CREDIT_CARD_BILL_LIMIT){
            return true;
        }
        else if(paymentInstrumentType.equals(PaymentInstrumentType.DEBIT_CARD) && cartAmount <= DEBIT_CARD_COMMERCE_LIMIT){
            return true;
        }
        return false;
    }
}
