package com.truongvietdung.config;

import com.truongvietdung.service.impl.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() { // cái này để mã hóa password
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(customerUserDetailsService);

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // class AuthenticationManagerBuilder là quản lý mọi xác thực
        auth.authenticationProvider(authenticationProvider());
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // class AuthenticationManagerBuilder là quản lý mọi xác thực
//        auth.userDetailsService(customerUserDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/admin/danh-sach/tin-tuc").hasAuthority("Xem tin tức")
            .antMatchers("/admin/danh-sach/chi-tiet/dich-vu").hasAuthority("Xem dịch vụ")
            .antMatchers("/admin/danh-sach/nhom-quyen").hasAuthority("Xem nhóm quyền")
            .antMatchers("/admin/danh-sach/nguoi-dung").hasAuthority("Xem người dùng")
            .antMatchers("/admin/danh-sach/thanh-pho").hasAuthority("Xem thành phố / tỉnh")
            .antMatchers("/admin/danh-sach/quan").hasAuthority("Xem quận / huyện")
            .antMatchers("/admin/danh-sach/phuong").hasAuthority("Xem phường / xã")
            .antMatchers("/admin/**").authenticated()
            .antMatchers("/templates/**").permitAll()
//            .antMatchers("/**").permitAll()
//            .antMatchers("/admin/**").hasAuthority("ADMIN")
//            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/dang-nhap").permitAll()
            .defaultSuccessUrl("/trang-chu")
            .failureUrl("/dang-nhap?sucess=fail")
            .loginProcessingUrl("/j_spring_security_check")
            .and()
            .exceptionHandling().accessDeniedPage("/404");


    }

}
