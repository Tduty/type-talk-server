package info.tduty.typetalkserver.repository;

import info.tduty.typetalkserver.data.entity.ClassEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassJpaRepository extends CrudRepository<ClassEntity, Long> {
}
