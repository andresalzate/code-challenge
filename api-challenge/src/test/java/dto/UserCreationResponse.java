package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreationResponse {

    private String name;
    private String job;
    private String id;
    private String createdAt;
}
