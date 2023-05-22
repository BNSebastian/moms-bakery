package family.momsbakery.cookies.service;

import family.momsbakery.cookies.entity.Cookie;
import family.momsbakery.cookies.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieServiceImpl implements CookieService{

    @Autowired
    private CookieRepository repository;

    @Override
    public void saveCookie(Cookie cookie) {
        repository.save(cookie);
    }

    @Override
    public Cookie getCookie(Long id) {
        if (repository.findById(id).isPresent()){
            return repository.findById(id).get();
        } else {
            throw new RuntimeException("Did not find " + Cookie.class.getName() + " with id: " + id);
        }
    }

    @Override
    public List<Cookie> getCookies() {
        if (!repository.findAll().isEmpty()){
            return repository.findAll();
        } else {
            throw new RuntimeException("Did not find any " + Cookie.class.getName());
        }
    }

    @Override
    public void updateCookie(Cookie cookie) {
        if (repository.findById(cookie.getId()).isPresent()){
            repository.save(cookie);
        } else {
            throw new RuntimeException("Did not find " + Cookie.class.getName() + " with id: " + cookie.getId());
        }
    }

    @Override
    public void deleteCookie(Long id) {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Did not find " + Cookie.class.getName() + " with id: " + id);
        }
    }
}
