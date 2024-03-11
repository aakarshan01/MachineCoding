package com.paymentrecommendation.service;

import com.paymentrecommendation.enums.LineOfBusiness;
import com.paymentrecommendation.models.Cart;
import com.paymentrecommendation.models.PaymentInstrument;
import com.paymentrecommendation.models.User;

import java.util.*;
import java.util.stream.Collectors;

import static com.paymentrecommendation.service.FiltersForInstrumentTypes.*;

/**
 * Created by aakarshan.gupta on 11/03/24.
 */
public class PaymentRecommenderImpl implements PaymentRecommender {
    @Override
    public List<PaymentInstrument> recommendPaymentInstruments(User user, Cart cart) {
        if(!validatePreconditions(user, cart)){
            System.out.println("Preconditions failed");
            return new ArrayList<>();
        }
        if(cart.getLineOfBusiness()==null){
            throw new RuntimeException("The line of business is not supported");
        }

        boolean isDeviceEnabledForUpi;
        if(user.getUserContext()==null || user.getUserContext().getDeviceContext()==null){
            isDeviceEnabledForUpi = false;
        } else {
            isDeviceEnabledForUpi = user.getUserContext().getDeviceContext().isUpiEnabled();
        }

        Map<LineOfBusiness, PaymentInstrumentFilter> lineOfBusinessToPaymentInstrumentFilterMap = new HashMap<>();
        lineOfBusinessToPaymentInstrumentFilterMap.put(LineOfBusiness.INVESTMENT, paymentInstrument-> filterPaymentInstrumentTypesForInvestment(paymentInstrument, cart.getCartDetail().getCartAmount(), isDeviceEnabledForUpi));
        lineOfBusinessToPaymentInstrumentFilterMap.put(LineOfBusiness.COMMERCE, paymentInstrument-> filterPaymentInstrumentTypesForCommerce(paymentInstrument, cart.getCartDetail().getCartAmount(), isDeviceEnabledForUpi));
        lineOfBusinessToPaymentInstrumentFilterMap.put(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, paymentInstrument-> filterPaymentInstrumentTypesForCreditCardBill(paymentInstrument, cart.getCartDetail().getCartAmount(), isDeviceEnabledForUpi));

        Map<LineOfBusiness, PaymentInstrumentSorter> lineOfBusinessToPaymentInstrumentSorterMap = new HashMap<>();
        lineOfBusinessToPaymentInstrumentSorterMap.put(LineOfBusiness.INVESTMENT, SortersForInstrumentTypes::sorterPaymentInstrumentTypesForInvestment);
        lineOfBusinessToPaymentInstrumentSorterMap.put(LineOfBusiness.COMMERCE, SortersForInstrumentTypes::sorterPaymentInstrumentTypesForCommerce);
        lineOfBusinessToPaymentInstrumentSorterMap.put(LineOfBusiness.CREDIT_CARD_BILL_PAYMENT, SortersForInstrumentTypes::sorterPaymentInstrumentTypesForCreditCardBill);



        PaymentInstrumentFilter paymentInstrumentFilter = lineOfBusinessToPaymentInstrumentFilterMap.get(cart.getLineOfBusiness());
        PaymentInstrumentSorter paymentInstrumentSorter = lineOfBusinessToPaymentInstrumentSorterMap.get(cart.getLineOfBusiness());

        List<PaymentInstrument> filteredPaymentInstruments = user.getUserPaymentInstrument().getPaymentInstruments().stream()
                .filter(paymentInstrumentFilter::apply)
                .sorted(paymentInstrumentSorter)
                .collect(Collectors.toList());


        return filteredPaymentInstruments;
    }



    private boolean validatePreconditions(User user, Cart cart) {
        if(user==null || cart==null){
            return false;
        }
        return true;
    }
}
