package frontend.javax.annotation_voltpatches;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import frontend.javax.annotation_voltpatches.meta.TypeQualifier;
import frontend.javax.annotation_voltpatches.meta.TypeQualifierValidator;
import frontend.javax.annotation_voltpatches.meta.When;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Nonnull {
    When when() default When.ALWAYS;

    static class Checker implements TypeQualifierValidator<Nonnull> {

        public When forConstantValue(Nonnull qualifierqualifierArgument,
                Object value) {
            if (value == null)
                return When.NEVER;
            return When.ALWAYS;
        }
    }
}
