package com.notepad.thinkingnote.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 用于字段描述的注解
 * <p>
 *     用于字段的描述, 运行期也保留
 * </p>
 * Create:      2018/7/15 17:58
 *
 * @author Yang Meng(eyangmeng@163.com)
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    String value() default "";
}
