package com.Group2.CSC422.CSP;

import java.util.concurrent.atomic.AtomicInteger;

public class CommonInfect extends Zombie {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    public CommonInfect(){
        setHealth(30);
        setDamage(5);
        setName("Common infect");
        setId(idGenerator.getAndIncrement());
    }
}
