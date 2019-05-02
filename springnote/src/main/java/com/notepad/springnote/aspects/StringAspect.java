package com.notepad.springnote.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description: 字符串切面
 * <p>
 *     1. 构造字符串切面, 完成切面的学习
 *     2. @Aspect注解
 *     3. TODO
 *          (1) @Around注解影响到了返回值, 不应该?? -> return proceed()
 *          (2) @After注解如何获取方法的返回值  -> 利用@AfterReturning
 *          (3) ProceedingJoinPoint的返回值是否如此?
 * </p>
 * Create:      2018/7/18 0:13
 *
 * @author Marvin Yang
 */

@Aspect
public class StringAspect {

    /** 无参数的切点 */
    @Pointcut("execution(* com.notepad.springnote.inject.StringProcess.stringB2Q(..))")
    public void process() {}

    @Before("process()")
    public void beforeProcess() {
        LOG.info("begin start processing.");
    }

    /**
     * 方法返回结果之后, 并且获取返回结果
     *
     *      1. argNames和returning中的参数名字一致, 则方法中名称不限制
     *      2. 不使用argNames, 保持returning参数名称和方法中一致
     *      3. returning: 通知绑定的返回参数名称
     *      4. TODO: argNames没弄清楚作用
     *
     * @param str 方法的返回参数
     */
    @AfterReturning(value = "process()", argNames = "st", returning = "st")
    public void afterProcess(String str) {
        LOG.info("@AfterReturning: after process, get result: {}", str);
    }

    /**
     * 早于@AfterReturning通知执行
     *
     */
    @After(value = "process()")
    public void afterProcess(JoinPoint jp) {
        System.out.println("after process.");
        for (Object arg : jp.getArgs()) {
            System.out.println(arg.getClass().getName());
        }
    }


    /** 带参数的切点
     *
     *      1. execution中指明参数类型, 非jdk类型指定全路径, eg. com.xxx.yyy.ClassT
     *      2. args中指明参数名称和个数, 与目标方法保持一致, 否则会导致无法匹配目标方法
     *
     */
    @Pointcut("execution(* com.notepad.springnote.inject.StringProcess.stringB2Q(String)) && args(content)")
    public void argsProcess(String content) {}

    /**
     * 定义Before通知, 记录初始参数
     *      1. 定义的通知方法参数名称与@Pointcut中的保持一致
     *
     * @param content 待转换的字符串
     */
    @Before("argsProcess(content)")
    public void beforeArgsProcess(String content) {
        LOG.info("the original content: {}", content);
    }


    /**
     * 定义Around通知, 记录处理全过程
     *
     * @param jp  @Around通知需使用ProceedingJoinPoint, 用来调用被通知的方法
     * @param content 待处理字符串
     */
    @Around("argsProcess(content)")
    public Object aroundProcessExecutor(ProceedingJoinPoint jp, String content) {
        LOG.info("around advice: the original content: {}", content);
        try {
            Object res = jp.proceed();
            LOG.info("around advice: the result content: {}", (String) res);
            return res;
        } catch (Throwable e) {
            LOG.error("around advice: catch throwable - [{}]", e.getMessage());
            return null;
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(StringAspect.class);
}
