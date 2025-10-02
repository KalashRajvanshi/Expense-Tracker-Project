package com.example.expensetrackerproject.DTO;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ModeOfPaymentReport {

//    public ModeOfPaymentReport(String modeOfPayment, Double totalAmount) {
//        this.modeOfPayment = modeOfPayment;
//        this.totalAmount = totalAmount;
//    }
    private final String modeOfPayment;
    private final Double totalAmount;
}
