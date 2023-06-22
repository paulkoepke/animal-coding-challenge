package dev.pkoepke.animalservice.converter;

/**
 * Interface for custom converter.
 *
 * @param <S> Source to convert from
 * @param <D> Destination to convert to
 */
public interface Converter<S, D> {

    D convert(S source);
}
