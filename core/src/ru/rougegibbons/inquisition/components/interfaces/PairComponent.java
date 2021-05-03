package ru.rougegibbons.inquisition.components.interfaces;

import com.badlogic.ashley.core.Component;
import org.jetbrains.annotations.Nullable;

public interface PairComponent<First, Second> extends Component {
    @Nullable First getFirst();

    @Nullable Second getSecond();

    void setFirst(@Nullable First first);

    void setSecond(@Nullable Second second);
}
