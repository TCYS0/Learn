package com.example.hystrixdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author SeaBreeze
 * @version 1.0
 * @description: TODO
 * @date 2023/4/7 8:46
 */
@Component
@Aspect
public class FishAspect {

    public static Map<String,Fish> fishMap = new HashMap<>();

    static {
        fishMap.put("order-server",new Fish());
    }

    Random random = new Random();

//    public static final String POIN_CUT = "excution(* )"
    @Around(value = "@annotation(com.example.hystrixdemo.MyFish)")
    public Object fishAround(ProceedingJoinPoint joinPoint){
        Object result = null;
        Fish fish = fishMap.get("order-service");
        FishStatus status = fish.getStatus();

        switch (status){
            case OPEN:
                return "wod";
            case CLOSE:
                try {
                    result = joinPoint.proceed();
                    return result;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                    //
                    fish.addFailCount();
                    return "cuole";
                }
            case HALF_OPEN:
                int i = random.nextInt(5);
                if (i == 1){
                    try {
                        result = joinPoint.proceed();
                        fish.setStatus(FishStatus.CLOSE);
                        return result;
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                        return "da";
                    }
                }
            default:
                return "sdf";
        }
    }
}
