package com.paymentrecommendation.service;

import com.paymentrecommendation.models.PaymentInstrument;

import java.util.Comparator;

@FunctionalInterface
public interface PaymentInstrumentSorter extends Comparator<PaymentInstrument> {

}
