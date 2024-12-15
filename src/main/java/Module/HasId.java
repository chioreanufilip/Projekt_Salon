package Module;

import java.io.Serializable;

/**
 * Functional interface representing an entity with a unique identifier.
 * This interface enforces the implementation of the {@code getId()} method
 * to retrieve the unique identifier of the implementing class.
 *
 * <p>As it extends {@code Serializable}, implementing classes can be serialized.</p>
 */
@FunctionalInterface
public interface HasId extends Serializable {

    /**
     * Retrieves the unique identifier for the implementing entity.
     *
     * @return the unique identifier as an {@code Integer}
     */
    Integer getId();
}
