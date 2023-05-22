package family.momsbakery.cookies.controller;

import family.momsbakery.cookies.entity.Cookie;
import family.momsbakery.cookies.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CookieController {

    @Autowired
    private CookieService service;

    @GetMapping("/cookies")
    public List<Cookie> getCookies() {
        return service.getCookies();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/cookies/{id}")
    public Cookie getCookie(@PathVariable Long id) {
        return service.getCookie(id);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/cookies")
    public void addCookie(@RequestBody Cookie cookie) {
        service.saveCookie(cookie);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/cookies")
    public void updateCookie(@RequestBody Cookie cookie) {
        service.saveCookie(cookie);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/cookies/{id}")
    public void deleteCookie(@PathVariable Long id) {
        service.deleteCookie(id);
    }

}
