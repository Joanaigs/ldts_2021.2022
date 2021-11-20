package com.aor.numbers;

public class DivisibleFilter implements GenericListFilter{
    private int n;
    DivisibleFilter(int n){
        this.n=n;
    }
    public boolean accept(Integer number){
        return (number%n==0);
    }

}
