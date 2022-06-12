package com.Group2.CSC422.CSP;
import java.util.concurrent.atomic.AtomicInteger;

public class Soldier extends Survivor{
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    public Soldier(){
        setHealth(50);
        setDamage(5);
        setName("Soldier");
        setId(idGenerator.getAndIncrement());
    }
}
