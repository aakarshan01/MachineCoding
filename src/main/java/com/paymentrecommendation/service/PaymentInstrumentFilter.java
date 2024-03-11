package com.paymentrecommendation.service;

import com.paymentrecommendation.models.PaymentInstrument;

@FunctionalInterface
public interface PaymentInstrumentFilter {
    boolean apply(PaymentInstrument paymentInstrument);
}
