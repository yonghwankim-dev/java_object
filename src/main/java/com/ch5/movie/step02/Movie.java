package com.ch5.movie.step02;



import java.time.Duration;
import java.util.List;

import com.ch5.money.Money;

public class Movie {
    private final String title;
    private final Duration runningTime;
    private final Money fee;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    private final List<PeriodCondition> periodConditions;
    private final List<SequenceCondition> sequenceConditions;

    public Movie(String title, Duration runningTime, Money fee,
                 List<PeriodCondition> periodConditions, List<SequenceCondition> sequenceConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.periodConditions = periodConditions;
        this.sequenceConditions = sequenceConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return checkPeriodConditions(screening) ||
                checkSequenceConditions(screening);
    }

    private boolean checkPeriodConditions(Screening screening) {
        return periodConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private boolean checkSequenceConditions(Screening screening) {
        return sequenceConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private Money calculateDiscountAmount() {
        switch(movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalStateException();
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }
}
