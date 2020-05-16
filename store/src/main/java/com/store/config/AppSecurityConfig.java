package com.store.config;

import com.store.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/product/addProduct").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.GET, "/product/allProduct").permitAll()
                .antMatchers(HttpMethod.DELETE, "/product/deleteProduct").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.PUT, "/product/updateProduct").hasAnyRole("vendor", "admin")

                .antMatchers(HttpMethod.POST, "/user/addUser").permitAll()
                .antMatchers(HttpMethod.POST, "/user/authorization").permitAll()
                .antMatchers(HttpMethod.GET, "/user/allUser").hasRole("admin")

                .antMatchers(HttpMethod.POST, "/address/addAddress").hasRole("customer")
                .antMatchers(HttpMethod.GET, "/address/allAddress").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.DELETE, "/address/deleteAddress").hasRole("customer")
                .antMatchers(HttpMethod.PUT, "/address/updateAddress").hasRole("customer")

                .antMatchers(HttpMethod.POST, "/billing/addBilling").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.GET, "/billing/allBilling").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.DELETE, "/billing/deleteBilling").hasAnyRole("vendor", "admin")

                .antMatchers(HttpMethod.POST, "/cart/addCart").hasRole("customer")
                .antMatchers(HttpMethod.GET, "/cart/allCart").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.DELETE, "/cart/deleteCart").hasRole("customer")

                .antMatchers(HttpMethod.POST, "/cartitem/addCartItem").hasRole("customer")
                .antMatchers(HttpMethod.GET, "/cartitem/allCartItem").hasRole("customer")
                .antMatchers(HttpMethod.DELETE, "/cartitem/deleteCartItem").hasRole("customer")

                .antMatchers(HttpMethod.POST, "/category/addCategory").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.GET, "/category/allCategory").permitAll()
                .antMatchers(HttpMethod.GET, "/category/getCategory").permitAll()
                .antMatchers(HttpMethod.DELETE, "/category/deleteCategory").hasRole("admin")

                .antMatchers(HttpMethod.POST, "/manufactor/addManufactor").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.GET, "/manufactor/allManufactor").permitAll()
                .antMatchers(HttpMethod.GET, "/manufactor/getManufactor").permitAll()
                .antMatchers(HttpMethod.DELETE, "/manufactor/deleteManufactor").hasAnyRole("vendor", "admin")

                .antMatchers(HttpMethod.POST, "/order/addOrder").hasRole("customer")
                .antMatchers(HttpMethod.GET, "/order/allOrder").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.DELETE, "/order/deleteOrder").hasRole("customer")

                .antMatchers(HttpMethod.POST, "/orderitem/addOrderItem").hasRole("customer")
                .antMatchers(HttpMethod.GET, "/orderitem/allOrderItem").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.DELETE, "/orderitem/deleteOrderItem").hasRole("customer")

                .antMatchers(HttpMethod.POST, "/role/addRole").hasRole("admin")
                .antMatchers(HttpMethod.GET, "/role/allRole").hasRole("admin")

                .antMatchers(HttpMethod.POST, "/payment/addPayment").hasRole("customer")
                .antMatchers(HttpMethod.GET, "/payment/allPayment").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.PUT, "/payment/updatePayment").hasRole("customer")

                .antMatchers(HttpMethod.POST, "/status/addStatus").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.GET, "/status/allStatus").hasAnyRole("vendor", "admin")
                .antMatchers(HttpMethod.PUT, "/status/updateStatus").hasAnyRole("vendor", "admin")

                .and()
                .formLogin().permitAll();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }


    }
