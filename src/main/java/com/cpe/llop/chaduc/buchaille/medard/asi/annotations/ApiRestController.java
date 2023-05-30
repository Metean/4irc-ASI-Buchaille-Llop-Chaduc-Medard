package com.cpe.llop.chaduc.buchaille.medard.asi.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@RequestMapping("/api")
@ResponseBody
public @interface ApiRestController {
    @AliasFor(
            annotation = Controller.class
    )
    String value() default "";

}
