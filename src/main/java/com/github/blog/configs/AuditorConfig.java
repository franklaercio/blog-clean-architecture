package com.github.blog.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.Random;

@Configuration
public class AuditorConfig implements AuditorAware<Integer> {

    /**
     * Back to operator logo information
     *
     * @return
     */
    @Override
    public Optional<Integer> getCurrentAuditor() {
        return Optional.of(new Random().nextInt(1000));
    }
}


