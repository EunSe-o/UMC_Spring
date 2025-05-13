package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = -453449888L;

    public static final QMission mission = new QMission("mission");

    public final StringPath city = createString("city");

    public final StringPath district = createString("district");

    public final StringPath missionDes = createString("missionDes");

    public final NumberPath<Integer> missionId = createNumber("missionId", Integer.class);

    public final StringPath missionName = createString("missionName");

    public final StringPath neighborhood = createString("neighborhood");

    public final ListPath<Review, QReview> reviews = this.<Review, QReview>createList("reviews", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<MissionStatus> status = createEnum("status", MissionStatus.class);

    public final ListPath<UserMission, QUserMission> userMissions = this.<UserMission, QUserMission>createList("userMissions", UserMission.class, QUserMission.class, PathInits.DIRECT2);

    public QMission(String variable) {
        super(Mission.class, forVariable(variable));
    }

    public QMission(Path<? extends Mission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMission(PathMetadata metadata) {
        super(Mission.class, metadata);
    }

}

