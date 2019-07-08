package org.forfun.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class PathUtil {

    public static String parsePath(String parentPath, String parent) {
        if (StringUtils.isEmpty(parentPath)) {
            parentPath = "";
        }
        if (StringUtils.isEmpty(parent)) {
            return parentPath;
        }
        StringBuffer buffer = new StringBuffer();
        String[] pathArray = parentPath.split(",");
        if (pathArray.length >= 3) {
            String[] workingArray = Arrays.copyOfRange(pathArray, pathArray.length - 3, pathArray.length);
            for (int i = 1; i < workingArray.length; i++) {
                if (!StringUtils.isEmpty(workingArray[i])) {
                    buffer.append(workingArray[i]).append(",");
                }
            }
            buffer.append(parent).append(",");
            return buffer.toString().trim();
        } else {
            for (String node : pathArray) {
                if (!StringUtils.isEmpty(node)) {
                    buffer.append(node).append(",");
                }
            }
            buffer.append(parent).append(",");
            return buffer.toString().trim();
        }
    }
}
