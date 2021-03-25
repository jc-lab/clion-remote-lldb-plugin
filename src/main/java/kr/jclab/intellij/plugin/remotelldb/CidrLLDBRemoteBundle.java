package kr.jclab.intellij.plugin.remotelldb;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

public class CidrLLDBRemoteBundle extends DynamicBundle {
    @NonNls
    private static final String BUNDLE = "messages.CidrLLDBRemoteBundle";
    private static final CidrLLDBRemoteBundle INSTANCE = new CidrLLDBRemoteBundle();

    public CidrLLDBRemoteBundle() {
        super(BUNDLE);
    }

    @NotNull
    @Nls
    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        if (key == null) {
            return "Key is null";
        }

        if (params == null) {
            return "Params is null";
        }

        String message = INSTANCE.getMessage(key, params);
        if (message == null) {
            return "Message is null";
        }

        return message;
    }

    @NotNull
    public static Supplier<String> messagePointer(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        if (key == null) {
            return () -> null;
        }

        if (params == null) {
            return () -> null;
        }

        Supplier<String> supplier = INSTANCE.getLazyMessage(key, params);
        if (supplier == null) {
            return () -> null;
        }

        return supplier;
    }
}
