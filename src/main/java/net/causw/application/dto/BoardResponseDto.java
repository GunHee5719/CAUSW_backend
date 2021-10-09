package net.causw.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.causw.domain.model.BoardDomainModel;
import net.causw.domain.model.CircleDomainModel;
import net.causw.domain.model.Role;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private String id;
    private String name;
    private String description;
    private List<String> createRoleList;
    private boolean writable;
    private Boolean isDeleted;

    private String circleId;
    private String circleName;

    private BoardResponseDto(
            String id,
            String name,
            String description,
            List<String> createRoleList,
            boolean writable,
            Boolean isDeleted,
            String circleId,
            String circleName
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.writable = writable;
        this.isDeleted = isDeleted;
        this.createRoleList = createRoleList;
        this.circleId = circleId;
        this.circleName = circleName;
    }

    public static BoardResponseDto from(BoardDomainModel boardDomainModel) {
        String circleId = boardDomainModel.getCircle().map(CircleDomainModel::getId).orElse(null);
        String circleName = boardDomainModel.getCircle().map(CircleDomainModel::getName).orElse(null);

        return new BoardResponseDto(
                boardDomainModel.getId(),
                boardDomainModel.getName(),
                boardDomainModel.getDescription(),
                boardDomainModel.getCreateRoleList(),
                false,
                boardDomainModel.getIsDeleted(),
                circleId,
                circleName
        );
    }

    public static BoardResponseDto from(BoardDomainModel boardDomainModel, Role userRole) {
        String circleId = boardDomainModel.getCircle().map(CircleDomainModel::getId).orElse(null);
        String circleName = boardDomainModel.getCircle().map(CircleDomainModel::getName).orElse(null);

        return new BoardResponseDto(
                boardDomainModel.getId(),
                boardDomainModel.getName(),
                boardDomainModel.getDescription(),
                boardDomainModel.getCreateRoleList(),
                boardDomainModel.getCreateRoleList().contains(userRole.getValue()),
                boardDomainModel.getIsDeleted(),
                circleId,
                circleName
        );
    }
}
