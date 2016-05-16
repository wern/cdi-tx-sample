package de.wern.infakt.cdi.transactions.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import javax.transaction.Transactional;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE) 
@Stereotype
@ApplicationScoped
@Transactional
@Named
public @interface SingletonService {
}
