package com.notepad.springnote;

import com.notepad.springnote.config.InjectConfig;
import com.notepad.springnote.inject.EncodeUtils;
import com.notepad.springnote.inject.StringProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: 依赖注入Main函数
 * <p>
 * Create:       2018/6/24 11:03
 *
 * @author Marvin Yang
 */
public class InjectBeanApplication {


    public static void main(String[] args) {
        StringProcess process = getStringProcess();
        if (process == null) {
            LOG.error("Can not create bean: StringProcess");
            return;
        }
        String content = "北京时间２３点整。";
        System.out.println(process.stringQ2B(content));

        // 汉字转拼音
        String eContent = "北京时间２３点整。";
        EncodeUtils encodeUtils = getEncodeUtils();
        EncodeUtils encodeUtilsConfig = getEncodeUtilsConfig();
        try {
            String pinyin = encodeUtils.string2Pinyin(eContent);
            System.out.println("separate:" + encodeUtils.getSeparate());
            System.out.println(pinyin);

            String pinyin2 = encodeUtilsConfig.string2Pinyin(eContent);
            System.out.println("separate:" + encodeUtilsConfig.getSeparate());
            System.out.println(pinyin2);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

    /**
     * 通过上下文加载获取bean
     *
     * @return StringProcess
     */
    private static StringProcess getStringProcess() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectConfig.class);
        return context.getBean(StringProcess.class);
    }

    /**
     * 通过上下文加载获取bean
     *  (1) 由于InjectConfig中有2个EncodeUtils的bean定义，需指定bean名称避免歧义
     *  (2) 此时加载inject-bean.xml中的EncodeUtils
     *
     * @return EncodeUtils
     */
    private static EncodeUtils getEncodeUtils() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectConfig.class);
        return (EncodeUtils) context.getBean("encodeUtils");
    }

    /**
     * 通过上下文加载获取字bean
     *  (1) 由于InjectConfig中有2个EncodeUtils的bean定义，需指定bean名称避免歧义
     *  (2) 此时加载InjectConfig中的EncodeUtils
     *
     * @return EncodeUtils
     */
    private static EncodeUtils getEncodeUtilsConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectConfig.class);
        return (EncodeUtils) context.getBean("encodeUtilsConfig");
    }

    private final static Logger LOG = LoggerFactory.getLogger(InjectBeanApplication.class);

}
