package com.dipankar.onlinestore.orders.util;



import com.dipankar.onlinestore.orders.util.exception.ApplicationException;
import com.dipankar.onlinestore.orders.util.exception.ExceptionType;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Collections.emptyList;

public class CommonUtil {

    /**
     * Returns the value contained in the given {@link Optional} if present, otherwise throws an {@link ApplicationException}
     * with {@link ExceptionType#NO_DATA_FOUND}.
     *
     * @param optional the Optional to extract the value from
     * @param <T> the type of the value
     * @return the contained value if present
     * @throws ApplicationException with ExceptionType.NO_DATA_FOUND if the Optional is empty
     */
    public static <T> T handleOptional(Optional<T> optional) throws ApplicationException {
        return optional.orElseThrow(() -> new ApplicationException(ExceptionType.NO_DATA_FOUND));
    }

    /**
     * Returns a non-null collection of the same type as the input.
     * If the input is null, returns an empty collection of the same type.
     *
     * @param value the input collection, possibly null
     * @param <T>   the type of the collection
     * @return      the original collection if not null, otherwise an empty collection of the same type
     */
    public static <T extends List<?>> T nullSafeList(T value) {
        return value == null ? (T) emptyList() : value;
    }


    /**
     * Converts a list of type T to a list of type R using the provided mapper function.
     * Returns an empty list if the input is null.
     *
     * @param input  the input list, possibly null
     * @param mapper the function to apply to each element
     * @param <T>    the type of elements in the input list
     * @param <R>    the type of elements in the resulting list
     * @return       a list of mapped elements, or an empty list if input is null
     */
    public static <T, R> List<R> convertList(List<T> input, Function<T, R> mapper) {
        return nullSafeList(input).stream().map(mapper).toList();
    }
}
