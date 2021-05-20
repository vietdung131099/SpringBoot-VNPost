package com.truongvietdung.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration // để bật được tính năng java config của spring framwork
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        public Optional<String> getCurrentAuditor() { // chỗ này là chỗ JPA Auditing get userName ra các trường được đánh dấu annotation @CreatedBy , @LastModifiedBy
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if(authentication == null){
                return null;
            }

            return Optional.ofNullable(authentication.getName()); // làm cách nào để lấy tên của người dùng thay vì userName
        }
    }
}
