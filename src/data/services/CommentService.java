package data.services;

import data.models.Comment;

public interface CommentService {

    String addComment(String content);

    Comment findCommentById(int id);
}
