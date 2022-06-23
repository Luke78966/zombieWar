package com.Group2.CSC422.CSP;

import java.util.concurrent.atomic.AtomicInteger;

public class Mercenary extends Survivor{
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    public Mercenary(){
        setHealth(100);
        setDamage(10);
        setName("Mercenary");
        setId(idGenerator.getAndIncrement());
    }
}
