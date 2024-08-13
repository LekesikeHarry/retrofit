package com.retrofitclient.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Post {

    private int userid;
    private int id;
    private String title;
    private String body;

}
