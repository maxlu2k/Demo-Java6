package com.application;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class I18NConfig implements WebMvcConfigurer{
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setDefaultEncoding("utf-8");
		ms.addBasenames("classpath:i18n/message");
		return ms;
	}
	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver lr = new CookieLocaleResolver();
		lr.setDefaultLocale(new Locale("vn")); //  ngôn ngữ mặc định == message_....properties
		lr.setCookieMaxAge(10*60*60);
		lr.setCookiePath("/");
		return lr;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor(); // cho phép thay đổi ngôn ngữ hiện tại trong mọi request đc cấu hình
		interceptor.setParamName("lang");
		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/image/**");
	}
}
