package ru.rougegibbons.inquisition.components.interfaces;

public interface NumericContainerComponent<T extends Number> extends ContainerComponent<T> {
    interface IntContainerComponent extends NumericContainerComponent<Integer> {

    }

    interface FloatContainerComponent extends NumericContainerComponent<Float> {

    }
}
