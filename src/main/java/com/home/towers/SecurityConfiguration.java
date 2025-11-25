package com.home.towers;

import com.home.towers.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader) // How to find users by their username
                .passwordEncoder(passwordEncoder()) // How to encode and verify passwords

        ;
    }
//     this looks to be an old way of adding static files to spring security
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry）{
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()

                .loginPage("/index")
                .defaultSuccessUrl("/home") // user's home page, it can be any URL

                .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/index?logout") // append a query string value
                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeRequests()
                .antMatchers("/", "/index", "/sign-up", "/login", "/index?logout", "users/avatars", "UsersProfile", "/Tim", "/secret", "import/calc", "import/cv", "import/calc.html", "import/three", "import/flickarchive", "import/weathermap", "import/coffee", "import/js/js.js", "import/js/maincoffee.js", "import/stylesheet/3dstyles.css", "import/stylesheet/archivestyles.css", "import/stylesheet/coffeestyles.css", "import/stylesheet/styles.css", "import/js/mapbox-geocoder-utils.js", "import/contact") // anyone can see these pages
                .permitAll()
                /* Pages that require authentication */
                .and()
                .authorizeRequests()
                .antMatchers(
                        "post", // only authenticated users can create ads
                        "groups",
                        "/groups",
                        "UserPostingForm",
                        "UsersHome",
                        "/UsersHome",
                        "UsersProfile",
                        "/post",
                        "/groups/{title}",
                        "/{username}",
                        "/home",
                        "/groups"/// maybe anyone can see usersprofiles but not post

                )
                .authenticated()
        ;
    }
}
