package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String s, String s1) {
    }
}
