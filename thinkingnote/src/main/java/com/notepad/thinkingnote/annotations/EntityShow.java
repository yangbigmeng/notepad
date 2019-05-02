package com.notepad.thinkingnote.annotations;

import java.lang.reflect.Field;

/**
 * Description: Entity关于Description的注解处理器
 * <p>
 * Create:      2018/7/15 18:33
 *
 * @author Marvin Yang
 */
public class EntityShow {

    /**
     * 显示Entity的字段描述信息
     *
     * @return string
     */
    public static String showFieldDescription(Entity entity) {
        StringBuilder stringBuilder = new StringBuilder(entity.getClass().getSimpleName()).append(":{ \n");
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field f : fields) {
            stringBuilder.append(f.getName());
            Description fieldDes = f.getAnnotation(Description.class);
            if (fieldDes != null) {
                stringBuilder.append(":").append(fieldDes.value());
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }

    public static void main(String [] args) {
        Entity entity = new Entity();
        entity.setName("笔记本电脑");
        entity.setUid("20180715");
        System.out.println(showFieldDescription(entity));
    }
}