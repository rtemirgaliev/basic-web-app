package tutorial.core.repositories.Jpa;

import org.springframework.stereotype.Repository;
import tutorial.core.models.entities.Blog;
import tutorial.core.repositories.BlogRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaBlogRepo implements BlogRepo {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Blog createBlog(Blog data) {
        return null;
    }

    @Override
    public List<Blog> findAllBlogs() {
        return null;
    }

    @Override
    public Blog findBlog(Long id) {
        return null;
    }

    @Override
    public Blog findBlogByTitle(String title) {
        return null;
    }

    @Override
    public List<Blog> findBlogsByAccount(Long accountId) {
        return null;
    }
}
