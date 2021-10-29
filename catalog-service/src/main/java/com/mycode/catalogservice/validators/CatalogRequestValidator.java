package com.mycode.catalogservice.validators;

import com.mycode.catalogservice.api.Catalog;
import com.mycode.catalogservice.api.MustRequired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.List;

@Component
public class CatalogRequestValidator implements RequestValidator<Catalog> {
    private List<String> annotatedFields;

    @PostConstruct
    public void init() {
            Field[] fields = Catalog.class.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].isAnnotationPresent(MustRequired.class)) {
                    MustRequired annotation = fields[i].getAnnotation(MustRequired.class);
                     if (annotation.required() == true)
                         annotatedFields.add(fields[i].getName());
                }
            }
    }

    @Override
    public void validate(Catalog catalog) throws IllegalAccessException {
       /* Field[] declaredFields = catalog.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            if (annotatedFields.contains(declaredFields[i].getName())) {
                declaredFields[i].setAccessible(true);
                Object value = declaredFields[i].get(catalog);
                if (value == null) {
                    throw new RuntimeException(declaredFields[i].getName() + "must not be empty");
                }
            }
        }*/
    }

}
