package com.tutorial.formvalidation.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target( {ElementType.METHOD, ElementType.FIELD} )
public @interface CourseCode {
	public String value() default "LUV";
	public String message() default "course code should start with LUV";
	
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
