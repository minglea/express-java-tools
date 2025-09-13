package club.mrxiao.sf.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2021-02-14
 */
public class SfGsonBuilder {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    private static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();

        // ✅ 注册 LocalDateTime 支持
        INSTANCE.registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                src == null ? null : new com.google.gson.JsonPrimitive(src.format(DATE_TIME_FORMATTER))
        );
        INSTANCE.registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                json == null || json.isJsonNull() ? null : LocalDateTime.parse(json.getAsString(), DATE_TIME_FORMATTER)
        );

        // ✅ 注册 LocalDate 支持
        INSTANCE.registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
                src == null ? null : new com.google.gson.JsonPrimitive(src.format(DATE_FORMATTER))
        );
        INSTANCE.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                json == null || json.isJsonNull() ? null : LocalDate.parse(json.getAsString(), DATE_FORMATTER)
        );

        // ✅ 注册 LocalTime 支持
        INSTANCE.registerTypeAdapter(LocalTime.class, (JsonSerializer<LocalTime>) (src, typeOfSrc, context) ->
                src == null ? null : new com.google.gson.JsonPrimitive(src.format(TIME_FORMATTER))
        );
        INSTANCE.registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (json, typeOfT, context) ->
                json == null || json.isJsonNull() ? null : LocalTime.parse(json.getAsString(), TIME_FORMATTER)
        );

        // ✅ 设置 java.util.Date 格式（也影响 java.sql.Timestamp）
        INSTANCE.setDateFormat(DATE_TIME_FORMAT);
    }

    public static Gson create() {
        return INSTANCE.create();
    }
}