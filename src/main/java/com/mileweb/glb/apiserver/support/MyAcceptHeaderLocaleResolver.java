package com.mileweb.glb.apiserver.support;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * 国际化时会用到，url可以添加参数来改变locale
 * @author whaon
 *
 */
public class MyAcceptHeaderLocaleResolver extends AcceptHeaderLocaleResolver {

    private Locale myLocal;

    public Locale resolveLocale(HttpServletRequest request) {
        return myLocal;
    } 

    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        myLocal = locale;
    }
  
}