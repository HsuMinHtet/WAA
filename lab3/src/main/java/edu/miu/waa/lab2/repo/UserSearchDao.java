package edu.miu.waa.lab2.repo;

import edu.miu.waa.lab2.domain.Comment;
import edu.miu.waa.lab2.domain.Post;
import edu.miu.waa.lab2.domain.User;
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

    public User findUserByCriteria(UserCriteriaRequest userCriteriaRequest) { // You can make a search request object for the input
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        List<Predicate> predicates = new ArrayList<>();

        // select * from User
        Root<User> root = criteriaQuery.from(User.class);

        Predicate userPredicate = criteriaBuilder.equal(root.get("id"), userCriteriaRequest.getUserId());
        predicates.add(userPredicate);
        // Join with Post entity
        if (userCriteriaRequest.getPostId() != null) {
            Join<User, Post> postJoin = root.join("posts",JoinType.INNER);
            Predicate postPredicate = criteriaBuilder.equal(postJoin.get("id"), userCriteriaRequest.getPostId());
            predicates.add(postPredicate);
        }
        // Join with Comment entity
        if (userCriteriaRequest.getCommentId() != null) {
            Join<Post, Comment> commentJoin = root.join("posts").join("commentList", JoinType.INNER);
            Predicate commentPredicate = criteriaBuilder.equal(commentJoin.get("id"), userCriteriaRequest.getCommentId());
            predicates.add(commentPredicate);
        }
        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );

        TypedQuery<User> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

}
