package family.momsbakery.cookies.repository;

import family.momsbakery.cookies.entity.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<Cookie, Long> {
    // TODO - define extra queries
}
