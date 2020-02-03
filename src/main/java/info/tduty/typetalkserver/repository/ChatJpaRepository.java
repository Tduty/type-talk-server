package info.tduty.typetalkserver.repository;

import info.tduty.typetalkserver.data.entity.ChatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatJpaRepository extends CrudRepository<ChatEntity, Long> {
}