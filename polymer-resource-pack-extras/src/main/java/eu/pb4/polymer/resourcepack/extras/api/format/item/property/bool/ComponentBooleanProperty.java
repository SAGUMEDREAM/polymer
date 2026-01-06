package eu.pb4.polymer.resourcepack.extras.api.format.item.property.bool;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.predicate.item.ItemSubPredicate;

import java.util.Map;

public record ComponentBooleanProperty(Map<ItemSubPredicate.Type<?>, ItemSubPredicate> predicate) implements BooleanProperty {
    public static final MapCodec<ComponentBooleanProperty> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(ItemSubPredicate.PREDICATES_MAP_CODEC.fieldOf("predicate").forGetter(ComponentBooleanProperty::predicate))
                .apply(instance, ComponentBooleanProperty::new);
    });

    public MapCodec<ComponentBooleanProperty> codec() {
        return CODEC;
    }
}