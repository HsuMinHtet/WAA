package edu.miu.waa.lab2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCriteriaRequest {
    private Long userId;
    private Long postId;
    private Long commentId;
}
