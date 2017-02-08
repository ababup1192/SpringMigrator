package org.ababup1192.common;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class DefaultEnvironment implements Environment{
    @Override
    public Long getTimeMilliSeconds() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
