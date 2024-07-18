package data.repository;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class PostRepositoryimpl implements PostRepository {

    private List<Post> posts = new ArrayList<Post>();


    @Override
    public void save(Post post) {
        int generatedNumber = generateUniqueId();
        post.setId(generatedNumber);
        posts.add(post);
    }

    private int generateUniqueId() {
        return ThreadLocalRandom.current().nextInt(6,10);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(int id) {
        for (Post post : posts) if (post.getId() == id) return post;
        return null;
    }

    @Override
    public void delete(int id) {
        posts.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        posts.clear();
    }

    @Override
    public long count() {
        return posts.size();
    }

    @Override
    public boolean isEmpty() {
        return (posts.isEmpty());
    }

}