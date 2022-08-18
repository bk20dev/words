package pl.bk20.words.util;

import org.jetbrains.annotations.Nullable;

import kotlin.reflect.KProperty;

@SuppressWarnings("unused")
public class Unsafe<T> {
    private T value = null;

    public T getValue(Object other, KProperty<?> property) {
        return value;
    }

    public void setValue(Object other, KProperty<?> property, @Nullable T value) {
        this.value = value;
    }
}
