package com.truongvietdung.mapper.custom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseMapperCustom<U> {
    public static <U> U convertToEntity(Object object,Class<U> uClass){
        try {
            U u = uClass.newInstance();
            Field[] sources = object.getClass().getDeclaredFields();
            Field[] targets = u.getClass().getDeclaredFields();
            /**
             * .getSuperClass() : có thêm cái này thì sẽ lấy được cả field của thằng mà nó extend
             * còn ko có thì chỉ có thể lấy được các field mà trong class đó định nghĩa
             * */
            for(Field target : targets){
                Field fieldTarget = target;
                for(Field source : sources){
                    Field fieldSource = source;
                    if(target.getName().equals(source.getName()) && source.getType().equals(target.getType())){
                        String getName = "get"+source.getName().substring(0,1).toUpperCase() + source.getName().substring(1);
                        Method method = object.getClass().getDeclaredMethod(getName);
                        target.setAccessible(true);
                        target.set(u,method.invoke(object));
                    }
                }
            }
            return u;

        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }


}
