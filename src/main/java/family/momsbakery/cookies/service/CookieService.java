package family.momsbakery.cookies.service;

import family.momsbakery.cookies.entity.Cookie;

import java.util.List;

public interface CookieService {

    void saveCookie(Cookie cookie);

    Cookie getCookie(Long id);

    List<Cookie> getCookies();

    void updateCookie(Cookie cookie);

    void deleteCookie(Long id);

}
