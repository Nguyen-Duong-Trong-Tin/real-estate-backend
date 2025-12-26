package com.springBootNoJwt.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {
  public static boolean isNullOrEmpty(String str) {
    return str == null || str.isEmpty();
  }

  public static <T> List<T> splitToList(String string, String delimiter, Class<T> tClass) {
    if (isNullOrEmpty(string)) {
      return null;
    }

    List<T> result = new ArrayList<>();
    String[] parts = string.split(delimiter);
    for (String part : parts) {
      String value = part.trim();
      if (value.isEmpty()) {
        continue;
      }
      try {
        if (tClass == String.class) {
          result.add(tClass.cast(value));
        } else if (tClass == Integer.class) {
          result.add(tClass.cast(Integer.valueOf(value)));
        } else if (tClass == Long.class) {
          result.add(tClass.cast(Long.valueOf(value)));
        } else if (tClass == Double.class) {
          result.add(tClass.cast(Double.valueOf(value)));
        } else if (tClass == Boolean.class) {
          result.add(tClass.cast(Boolean.valueOf(value)));
        } else {
          throw new IllegalArgumentException("Unsupported type: " + tClass.getName());
        }
      } catch (NumberFormatException ignored) {
      }
    }

    return result.isEmpty() ? null : result;
  }
}
