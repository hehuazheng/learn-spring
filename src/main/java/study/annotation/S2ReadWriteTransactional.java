package study.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Target(java.lang.annotation.ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Transactional(value = "s2TransactionManager", readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
public @interface S2ReadWriteTransactional {
}
