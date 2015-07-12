package com.kimifdw.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

/**
 * 所有控制类的基类
 * Created by kimiyu on 15/7/11.
 */
public abstract class BaseController {

    /**
     * 初始化参数绑定
     * 将所有传递进来的String进行HTML编码，防止XSS攻击
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {

            @Override
            public String getAsText(){
                Object value = getValue();
                return value!=null?value.toString():"";
            }


            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }


        });
    }
}
