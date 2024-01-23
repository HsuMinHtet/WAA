package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Comment;
import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.User;
import edu.miu.waa.lab2.dto.UserCriteriaRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserSearchDao {
    private final EntityManager em;

    public User findUserByCriteria(UserCriteriaRequest userCriteriaRequest) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        List<Predicate> predicates = new ArrayList<>();

        // Select * from Users
        Root<User> root = criteriaQuery.from(User.class);

        // Add predicate for User ID
        if (userCriteriaRequest.getUserId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), userCriteriaRequest.getUserId()));
        }

        // Join with Post entity and add predicate for Post ID
        Join<User, Post> postJoin = root.join("posts", JoinType.INNER);
        if (userCriteriaRequest.getPostId() != null) {
            predicates.add(criteriaBuilder.equal(postJoin.get("id"), userCriteriaRequest.getPostId()));
        }

        // Join with Comment entity and add predicate for Comment ID
        Join<Post, Comment> commentJoin = postJoin.join("commentList", JoinType.INNER);
        if (userCriteriaRequest.getCommentId() != null) {
            predicates.add(criteriaBuilder.equal(commentJoin.get("id"), userCriteriaRequest.getCommentId()));
        }

        // Build the WHERE clause
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(criteriaQuery).getSingleResult();
//        try {
//            return em.createQuery(criteriaQuery).getSingleResult();
//        } catch (NoResultException e) {
//            return null; // Handle case when no result is found
//        }
    }

}
