package info.tduty.typetalkserver.domain.mapper;

import info.tduty.typetalkserver.data.dto.ClassCreatedDTO;
import info.tduty.typetalkserver.data.dto.ClassDTO;
import info.tduty.typetalkserver.data.dto.CreateClassDTO;
import info.tduty.typetalkserver.data.entity.ClassEntity;
import info.tduty.typetalkserver.data.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClassMapper {

    public ClassEntity dtoToDB(CreateClassDTO createClassDTO, List<UserEntity> users) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(UUID.randomUUID().toString());
        classEntity.setTitle(createClassDTO.getTitle());
        classEntity.setStudents(new HashSet<>(users));
        return classEntity;
    }

    public ClassCreatedDTO dbToCreatedDTO(ClassEntity classEntity) {
        return new ClassCreatedDTO(
                classEntity.getId(),
                classEntity.getTitle(),
                "", //TODO добавить в слой данных
                classEntity.getStudents().stream().map(this::mapToUserDTO).collect(Collectors.toList())
        );
    }

    public ClassDTO dbToClassDTO(ClassEntity classEntity) {
        return new ClassDTO(
                classEntity.getId(),
                classEntity.getTitle(),
                classEntity.getAvatar(), //TODO добавить дескрипшен
                classEntity.getStudents().size()
        );
    }

    private CreateClassDTO.UserDTO mapToUserDTO(UserEntity userEntity) {
        return new CreateClassDTO.UserDTO(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSex()
        );
    }
}
