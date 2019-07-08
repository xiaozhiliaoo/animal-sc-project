package org.forfun.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Iterator;
import java.util.Map;


public class JavaScript {

    private static final Logger LOG = LoggerFactory.getLogger(JavaScript.class);

    private static ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Object eval(Map<String, Object> map, String option) {
        try {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                option = option.replaceAll(entry.getKey(), entry.getValue().toString());
            }

            LOG.info("计算表达式：{}值开始！", option);
            Object obj = engine.eval(option);
            LOG.info("计算表达式：{}值结束！返回：{}", new Object[]{option, obj});
            return obj;
        } catch (ScriptException e) {
            e.printStackTrace();
            LOG.info("计算表达式：{}值失败！原因：", new Object[]{option, e.toString()}, e);
            return null;
        }
    }

    public static Boolean evalAsBoolean(Map<String, Object> map, String option) {
        Object obj = eval(map, option);
        try {
            return Boolean.parseBoolean(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Double evalAsDouble(Map<String, Object> map, String option) {
        Object obj = eval(map, option);
        try {
            return Double.parseDouble(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer evalAsInteger(Map<String, Object> map, String option) {
        Object obj = eval(map, option);
        try {
            return Integer.parseInt(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String evalAsString(Map<String, Object> map, String option) {
        Object obj = eval(map, option);
        return obj.toString();
    }
}
