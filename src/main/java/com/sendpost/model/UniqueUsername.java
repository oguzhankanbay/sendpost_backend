package com.sendpost.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueUsernameValidation.class })
public @interface UniqueUsername {

	String message() default "{sendpost.constraint.username.unique.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
