package net.causw.application.dto.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCreateRequestDto {
    private String name;
    private String description;
    private List<String> createRoleList;
    private String category;

    private String circleId;

    public Optional<String> getCircleId() {
        return Optional.ofNullable(this.circleId);
    }
}
