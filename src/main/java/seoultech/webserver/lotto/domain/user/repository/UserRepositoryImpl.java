package seoultech.webserver.lotto.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import seoultech.webserver.lotto.domain.user.User;
import seoultech.webserver.lotto.domain.user.UserSocialType;

import static seoultech.webserver.lotto.domain.user.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public User findUserBySocialIdAndSocialType(String socialId, UserSocialType socialType) {
        return queryFactory
                .selectFrom(user)
                .where(
                        user.socialInfo.socialId.eq(socialId),
                        user.socialInfo.socialType.eq(socialType)
                ).fetchFirst();
    }

    @Override
    public User findUserById(Long id) {
        return queryFactory
                .selectFrom(user)
                .where(
                        user.id.eq(id)
                )
                .fetchOne();
    }
}
