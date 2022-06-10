package fr.codeflow.draughtsapi.validator;


import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAtLeastOneNotNullValidator implements ConstraintValidator<CheckAtLeastOneNotNull, Object> {

    private String[] fieldNames;

    @Override
    public void initialize(CheckAtLeastOneNotNull constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fieldNames();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return true;
        }
        try {
            for (String fieldName : fieldNames) {
//                Object property = PropertyUtils.getProperty(object, fieldName);

                Object property = new BeanWrapperImpl(object)
                        .getPropertyValue(fieldName);

                if (property != null) return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}