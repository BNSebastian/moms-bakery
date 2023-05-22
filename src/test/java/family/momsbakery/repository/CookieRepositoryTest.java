package family.momsbakery.repository;
import family.momsbakery.cookies.entity.Cookie;

import family.momsbakery.cookies.repository.CookieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CookieRepositoryTest {

    @Autowired
    private CookieRepository repository;

    @Test
    public void cookieRepository_saveCookie() {
        // create
        Cookie cookie = Cookie.builder()
                .name("savarina")
                .price(6)
                .build();
        // act
        Cookie savedCookie = repository.save(cookie);
        // assert
        Assertions.assertThat(savedCookie).isNotNull();
        Assertions.assertThat(savedCookie.getId()).isGreaterThan(0);
        // delete created objects
        repository.deleteById(savedCookie.getId());
    }

    @Test
    public void cookieRepository_getCookies() {
        // create
        Cookie cookie1 = Cookie.builder()
                .name("savarina")
                .price(6)
                .build();
        Cookie cookie2 = Cookie.builder()
                .name("amandina")
                .price(5)
                .build();
        // act
        Cookie savedCookie1 = repository.save(cookie1);
        Cookie savedCookie2 = repository.save(cookie2);
        List<Cookie> cookieList = repository.findAll();
        // assert
        Assertions.assertThat(cookieList).contains(savedCookie1);
        Assertions.assertThat(cookieList).contains(savedCookie2);
        // delete created objects
        repository.deleteById(savedCookie1.getId());
        repository.deleteById(savedCookie2.getId());
    }

    @Test
    public void cookieRepository_getCookie() {
        // create
        Cookie cookie = Cookie.builder()
                .name("savarina")
                .price(6)
                .build();
        // act
        repository.save(cookie);
        Cookie returnedCookie = null;
        if (repository.findById(cookie.getId()).isPresent()) {
            returnedCookie = repository.findById(cookie.getId()).get();
        }
        // assert
        Assertions.assertThat(returnedCookie).isNotNull();
        // delete created objects
        repository.deleteById(cookie.getId());
    }

    @Test
    public void cookieRepository_updateCookie() {
        // create
        Cookie cookie = Cookie.builder()
                .name("savarina")
                .price(6)
                .build();
        // act
        repository.save(cookie);
        Cookie updatedCookie = repository.findById(cookie.getId()).get();
        updatedCookie.setName("negresa");
        repository.save(updatedCookie);
        // assert
        Assertions.assertThat(repository.findById(cookie.getId()).get().getName().equals("negresa"));
        // delete created objects
        repository.deleteById(cookie.getId());
    }

}