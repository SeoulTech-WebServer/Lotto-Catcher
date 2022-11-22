package seoultech.webserver.lotto.domain.user.repository;

import seoultech.webserver.lotto.domain.user.User;
import seoultech.webserver.lotto.domain.user.UserSocialType;

public interface UserRepositoryCustom {

    User findUserBySocialIdAndSocialType(String socialId, UserSocialType socialType);

    User findUserById(Long id);
}
