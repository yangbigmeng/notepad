package com.notepad.thinkingnote.annotations;

/**
 * Description: 实体定义
 * <p>
 *     使用Description注解
 * </p>
 * Create:      2018/7/15 18:02
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public class Entity {

    @Description("实体名称")
    private String name;

    @Description("实体UID")
    private String uid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
