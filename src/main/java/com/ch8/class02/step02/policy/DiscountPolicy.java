package com.ch8.class02.step02.policy;

import java.util.ArrayList;
import java.util.List;

import com.ch8.class02.step02.condition.DiscountCondition;
import com.ch8.class02.step02.domain.Money;
import com.ch8.class02.step02.domain.Screening;

public abstract class DiscountPolicy {
	// 표준 클래스 라이브러리(ArrayList)는 변경될 가능성이 적기 때문에 의존성해도 결합도가 상승하지 않는다
	private List<DiscountCondition> conditions = new ArrayList<>();

	public void switchConditions(List<DiscountCondition> conditions){
		this.conditions = conditions;
	}

	public abstract Money calculateDiscountAmount(Screening screening);
}
