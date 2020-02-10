package com.magic.redis.Aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wheel {
    @Value("马牌")
    private String name;
    @Value("225")
    private Integer size;
}
