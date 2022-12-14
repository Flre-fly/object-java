package org.example.ch02;

import java.time.Duration;

public class Movie {
    private String title; // 제목
    private Duration runningTime; // 상영시간
    private double fee; // 기본 요금
    private DiscountPolicy discountPolicy; // 할인 정책

    //확장을 사용했기 때문에 런타임에 객체를 교체할 수 있음
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Movie(String title, Duration runningTime, double fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }
    public double calculateMovieFee(Screening screening) {
        //if문으로 예외를 만들지 않는다.
        //항상 같은 처리를 하도록 만든다
        return fee - discountPolicy.calculateDiscountAmount(screening);
    }
    public double discountByAmount(int amount){
        return fee - amount;
    }
    public double discountByPercent(int percent){
        return fee * percent/100;
    }
    public double getFee() {
        return fee;
    }

}
