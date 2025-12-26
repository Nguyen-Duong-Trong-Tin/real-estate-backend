package com.springBootNoJwt.utils;

import java.util.Map;

public class MapUtil {
  public static <T> T getObject(Map<String, String> query, String key, Class<T> tClass) {
    String value = query.get(key);
    if (value == null || value.trim().isEmpty()) {
      return null;
    }

    try {
      return switch (tClass) {
        case Class<?> c when c == String.class -> tClass.cast(value);
        case Class<?> c when c == Integer.class -> tClass.cast(Integer.parseInt(value));
        case Class<?> c when c == Long.class -> tClass.cast(Long.parseLong(value));
        case Class<?> c when c == Boolean.class -> tClass.cast(Boolean.parseBoolean(value));
        default -> null;
      };
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
