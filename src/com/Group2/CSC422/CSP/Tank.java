package com.Group2.CSC422.CSP;
import java.util.concurrent.atomic.AtomicInteger;

public class Tank extends Zombie{
    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    public Tank(){
        setHealth(150);
        setDamage(20);
        setName("Tank");
        setId(idGenerator.getAndIncrement());

    }
}
