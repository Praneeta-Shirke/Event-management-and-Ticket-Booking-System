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
    private Payment_status p_status;
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
    public Payment_status getP_status() {
        return p_status;
    }
    public void setP_status(Payment_status p_status) {
        this.p_status = p_status;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Payment(int p_id, int b_id, String mode, Payment_status p_status, LocalDate paymentDate) {
        this.p_id = p_id;
        this.b_id = b_id;
        this.mode = mode;
        this.p_status = p_status;
        this.paymentDate = paymentDate;
    }
    @Override
    public String toString() {
        return "Payment [p_id=" + p_id + ", b_id=" + b_id + ", mode=" + mode + ", p_status=" + p_status
                + ", paymentDate=" + paymentDate + ", getP_id()=" + getP_id() + ", getB_id()=" + getB_id()
                + ", getMode()=" + getMode() + ", getP_status()=" + getP_status() + ", getPaymentDate()="
                + getPaymentDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    

}
