package me.j360.jdk.application.remote.annotation;

import java.lang.annotation.*;


/**
 * ��ʾ�ֶβ�����Ϊ��
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface NotNull {
}