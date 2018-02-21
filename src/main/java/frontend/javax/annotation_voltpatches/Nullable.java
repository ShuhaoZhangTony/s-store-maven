package frontend.javax.annotation_voltpatches;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import frontend.javax.annotation_voltpatches.meta.TypeQualifierNickname;
import frontend.javax.annotation_voltpatches.meta.When;

@Documented
@TypeQualifierNickname
@Nonnull(when = When.UNKNOWN)
@Retention(RetentionPolicy.RUNTIME)
public @interface Nullable {

}
