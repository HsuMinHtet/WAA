package edu.miu.waa.lab2.dto;

import edu.miu.waa.lab2.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    long id;
    String title;
    String content;
    String author;
    List<Comment> commentList;
}
