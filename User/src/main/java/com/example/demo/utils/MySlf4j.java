package com.example.demo.utils;

import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-09-26 17:21
 **/
public class MySlf4j {
    /**空数组*/
    private static final Object[] EMPTY_ARRAY = new Object[] {};
    /**全类名*/
    private static final String FQCN = MySlf4j.class.getName();

    /**
     * 获取栈中类信息
     * @param stackDepth 栈深（下标） 2：调用者类信息
     * @return org.slf4j.spi.LocationAwareLogger
     * @author wxt
     * @date 2019/7/10 8:40
     */
    private static LocationAwareLogger getLocationAwareLogger(final int stackDepth) {
        /**通过堆栈信息获取调用当前方法的类名和方法名*/
        JavaLangAccess access = SharedSecrets.getJavaLangAccess();
        Throwable throwable = new Throwable();
        StackTraceElement frame = access.getStackTraceElement(throwable, stackDepth);
        return (LocationAwareLogger) LoggerFactory.getLogger(frame.getClassName());
    }

    /**
     * 封装Debug级别日志
     * @param msg
     * @param arguments
     * 作者：wxt
     * 日期：2019年3月27日下午5:38:01
     */
    public static void textDebug(String msg, Object... arguments) {
        if (arguments != null && arguments.length > 0) {
            MessageFormat temp = new MessageFormat(msg);
            msg = temp.format(arguments);
        }
        getLocationAwareLogger(2).log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, EMPTY_ARRAY, null);
    }

    /**
     * 封装Info级别日志
     * @param msg
     * @param arguments
     * 作者：wxt
     * 日期：2019年3月27日下午5:37:42
     */
    public static void textInfo(String msg, Object... arguments) {
        if (arguments != null && arguments.length > 0) {
            MessageFormat temp = new MessageFormat(msg);
            msg = temp.format(arguments);
        }
        getLocationAwareLogger(2).log(null, FQCN, LocationAwareLogger.INFO_INT, msg, EMPTY_ARRAY, null);
    }

    /**
     * 封装Warn级别日志
     * @param msg
     * @param arguments
     * 作者：wxt
     * 日期：2019年3月27日下午5:37:30
     */
    public static void textWarn(String msg, Object... arguments) {
        if (arguments != null && arguments.length > 0) {
            MessageFormat temp = new MessageFormat(msg);
            msg = temp.format(arguments);
        }
        getLocationAwareLogger(2).log(null, FQCN, LocationAwareLogger.WARN_INT, msg, EMPTY_ARRAY, null);
    }

    /**
     * 封装Error级别日志
     * @param msg
     * @param arguments
     * 作者：wxt
     * 日期：2019年3月27日下午5:37:14
     */
    public static void textError(String msg, Object... arguments) {
        if (arguments != null && arguments.length > 0) {
            MessageFormat temp = new MessageFormat(msg);
            msg = temp.format(arguments);
        }
        getLocationAwareLogger(2).log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, EMPTY_ARRAY, null);
    }

    /**
     * 异常堆栈转字符串
     * @param e
     * @return
     * 作者：wxt
     * 日期：2019年3月27日下午5:37:08
     */
    public static String ExceptionToString(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            if (e == null) {
                return "无具体异常信息";
            }
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception ex) {
            MySlf4j.textError("异常堆栈转字符串异常", ex);
            return "";
        } finally {
            sw.flush();
            pw.flush();
            pw.close();
        }

    }

}
