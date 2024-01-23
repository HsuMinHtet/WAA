package edu.miu.waa.lab2.dto;

import edu.miu.waa.lab2.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO {
    Long id;
    String name;
    List<Post> posts;
}
