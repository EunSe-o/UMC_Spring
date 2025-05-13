package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFood is a Querydsl query type for Food
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFood extends EntityPathBase<Food> {

    private static final long serialVersionUID = -1348495606L;

    public static final QFood food = new QFood("food");

    public final NumberPath<Integer> foodId = createNumber("foodId", Integer.class);

    public final StringPath foodName = createString("foodName");

    public final ListPath<UserFood, QUserFood> userFoods = this.<UserFood, QUserFood>createList("userFoods", UserFood.class, QUserFood.class, PathInits.DIRECT2);

    public QFood(String variable) {
        super(Food.class, forVariable(variable));
    }

    public QFood(Path<? extends Food> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFood(PathMetadata metadata) {
        super(Food.class, metadata);
    }

}

