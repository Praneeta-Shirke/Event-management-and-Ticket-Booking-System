package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;
    private int b_id;
    private String mode;
    private boolean payment_status;
    private LocalDate paymentDate;
    public int getP_id() {
        return p_id;
    }
    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
    public int getB_id() {
        return b_id;
    }
    public void setB_id(int b_id) {
        this.b_id = b_id;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public boolean isPayment_status() {
        return payment_status;
    }
    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Payment(int p_id, int b_id, String mode, boolean payment_status, LocalDate paymentDate) {
        this.p_id = p_id;
        this.b_id = b_id;
        this.mode = mode;
        this.payment_status = payment_status;
        this.paymentDate = paymentDate;
    }
    @Override
    public String toString() {
        return "Payment [p_id=" + p_id + ", b_id=" + b_id + ", mode=" + mode + ", payment_status=" + payment_status
                + ", paymentDate=" + paymentDate + ", getP_id()=" + getP_id() + ", getB_id()=" + getB_id()
                + ", getMode()=" + getMode() + ", isPayment_status()=" + isPayment_status() + ", getPaymentDate()="
                + getPaymentDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }
}
