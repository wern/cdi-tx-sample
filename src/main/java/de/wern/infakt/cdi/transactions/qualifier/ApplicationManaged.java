package de.wern.infakt.cdi.transactions.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER} )
@Qualifier
public @interface ApplicationManaged {
}
