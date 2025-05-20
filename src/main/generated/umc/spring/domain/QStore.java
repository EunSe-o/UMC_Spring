package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 1158464437L;

    public static final QStore store = new QStore("store");

    public final StringPath address = createString("address");

    public final StringPath city = createString("city");

    public final StringPath district = createString("district");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Mission, QMission> missions = this.<Mission, QMission>createList("missions", Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath neighborhood = createString("neighborhood");

    public QStore(String variable) {
        super(Store.class, forVariable(variable));
    }

    public QStore(Path<? extends Store> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStore(PathMetadata metadata) {
        super(Store.class, metadata);
    }

}

