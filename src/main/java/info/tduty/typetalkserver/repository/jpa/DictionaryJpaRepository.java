package info.tduty.typetalkserver.repository.jpa;

import info.tduty.typetalkserver.data.entity.DictionaryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryJpaRepository extends CrudRepository<DictionaryEntity, String> {
}
