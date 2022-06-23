package com.Group2.CSC422.CSP;

import java.util.concurrent.atomic.AtomicInteger;

public class Newbie extends Survivor{
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    public Newbie(){
        setHealth(20);
        setDamage(2);
        setName("Newbie");
        setId(idGenerator.getAndIncrement());
    }

}
