package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Comment;
import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.Users;
import edu.miu.waa.lab2.dto.UserCriteriaRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserSearchDao {
    private final EntityManager em;
    public Users findUserByCriteria(UserCriteriaRequest userCriteriaRequest) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);
        List<Predicate> predicates = new ArrayList<>();

        // Select * from Users
        Root<Users> root = criteriaQuery.from(Users.class);

        // Add predicate for User ID
        Predicate userPredicate = criteriaBuilder.equal(root.get("id"), userCriteriaRequest.getUserId());
        predicates.add(userPredicate);

        // Join with Post entity and add predicate for Post ID
        if (userCriteriaRequest.getPostId() != null) {
            Join<Users, Post> postJoin = root.join("posts", JoinType.INNER);
            Predicate postPredicate = criteriaBuilder.equal(postJoin.get("id"), userCriteriaRequest.getPostId());
            predicates.add(postPredicate);
        }

        // Join with Comment entity and add predicate for Comment ID
        if (userCriteriaRequest.getCommentId() != null) {
            Join<Users, Post> postJoin = root.join("posts", JoinType.INNER);
            Join<Post, Comment> commentJoin = postJoin.join("commentList", JoinType.INNER);
            Predicate commentPredicate = criteriaBuilder.equal(commentJoin.get("id"), userCriteriaRequest.getCommentId());
            predicates.add(commentPredicate);
        }

        // Build the WHERE clause
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Users> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

}
